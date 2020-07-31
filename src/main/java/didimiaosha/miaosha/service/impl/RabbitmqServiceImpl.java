package didimiaosha.miaosha.service.impl;

import didimiaosha.miaosha.config.RabbitConfig;
import didimiaosha.miaosha.entity.Order;
import didimiaosha.miaosha.service.IOrderService;
import didimiaosha.miaosha.service.IRabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitmqServiceImpl implements IRabbitmqService {


    @Autowired
    private IOrderService orderService;

    @Override
    @RabbitListener(queues = RabbitConfig.ORDER_QUEUE)
    public void createOrder(Order order) {
        log.info("收到订单消息，订单用户为：{}，商品名称为：{}", order.getUserId(), order.getGoodId());
        try {
            orderService.createOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @RabbitListener(queues = RabbitConfig.STORY_QUEUE)
    public void decrBy(Long goodsId) {
        log.info("库存消息队列收到的消息商品信息是：{}", goodsId);
       orderService.decrBy(goodsId);
    }
}
