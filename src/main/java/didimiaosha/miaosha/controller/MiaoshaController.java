package didimiaosha.miaosha.controller;

import didimiaosha.miaosha.config.RabbitConfig;
import didimiaosha.miaosha.utils.DateUtils;
import didimiaosha.miaosha.utils.RedisUtil;
import didimiaosha.miaosha.entity.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@Slf4j
public class MiaoshaController {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 使用redis+消息队列进行秒杀实现
     *
     * @param userId
     * @param goodsId
     * @return
     */
    @RequestMapping(value = "/sec", method = RequestMethod.GET)
    @ResponseBody
    public String sec(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "goodsId") Long goodsId) {
        log.info("参加秒杀的用户是：{}，秒杀的商品是：{}", userId, goodsId);
        String message = null;
        //调用redis给相应商品库存量减一

        Long decrByResult = Long.valueOf(redisUtil.get("goodsId_" + goodsId.toString()).toString());
        if (decrByResult > 0) {
            /**
             * 说明该商品的库存量有剩余，可以进行下订单操作
             */
            log.info("用户：{}秒杀该商品：{}库存有余，可以进行下订单操作", userId, decrByResult);
            if (redisUtil.hasKey(userId + "_" + goodsId)) {
                log.info("用户" + userId + "已经秒杀");
                return "用户" + userId + "已经秒杀";
            }
            redisUtil.set(userId + "_" + goodsId, null);

//            rabbitTemplate.convertAndSend(RabbitConfig.STORY_EXCHANGE, RabbitConfig.STORY_ROUTING_KEY, goodsId);

            //发消息给订单消息队列，创建订单
            Order order = new Order();
            order.setGoodId(goodsId);
            order.setUserId(userId);
            rabbitTemplate.convertAndSend(RabbitConfig.ORDER_EXCHANGE, RabbitConfig.ORDER_ROUTING_KEY, order);
            message = "用户" + userId + "秒杀" + goodsId + "成功";
        } else {
            /**
             * 说明该商品的库存量没有剩余，直接返回秒杀失败的消息给用户
             */
            log.info("用户：{}秒杀时商品的库存量没有剩余,秒杀结束", userId);
            message = userId + "商品的库存量没有剩余,秒杀结束";
        }
        return message;
    }


    /**
     * @param
     * @return
     * @description redis 中存放秒杀的商品的数据
     * @author suewong
     * @date 2020/7/31 14:26
     */
    @RequestMapping(value = "/setGoods", method = RequestMethod.GET)
    public void setGoods() {
        redisUtil.set("goodsId_" + "1", 100);
        redisUtil.set("goodsId_" + "2", 100);
        redisUtil.set("goodsId_" + "3", 100);
        redisUtil.set("goodsId_" + "4", 100);
    }



}
