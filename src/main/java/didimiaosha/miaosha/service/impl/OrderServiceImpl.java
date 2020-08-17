package didimiaosha.miaosha.service.impl;

import com.sun.org.apache.xpath.internal.operations.Bool;
import didimiaosha.miaosha.utils.DateUtils;
import didimiaosha.miaosha.utils.RedisUtil;
import didimiaosha.miaosha.entity.Goods;
import didimiaosha.miaosha.entity.Order;
import didimiaosha.miaosha.mapper.GoodsMapper;
import didimiaosha.miaosha.mapper.OrderMapper;
import didimiaosha.miaosha.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Transactional
    public boolean createOrder(Order order) throws Exception {


        if (order == null || order.getGoodId() == null || order.getUserId() == null) {
            throw new Exception();
        }
        Goods goods = goodsMapper.selectByPrimaryKey(order.getGoodId());

       if (redisUtil.hasKey(order.getUserId() + "_" + order.getGoodId())){

           log.info("---------------------------------");
           if (redisUtil.get(order.getUserId() + "_" + order.getGoodId())!=null){
               log.info("++++++++++++++++++++++++++++++");
               Boolean flag=(Boolean)redisUtil.get(order.getUserId() + "_" + order.getGoodId());

               log.info(flag+"++++++++++++++++++++++++++");
               if (flag==true){
                   log.info("用户"+order.getUserId()+"已经秒杀----------");
                   return false;
               }

           }

       }

        if (goodsMapper.decrBy(order.getGoodId()) > 0 && orderMapper.insertSelective(order) > 0) {
            redisUtil.set(order.getUserId() + "_" + order.getGoodId(), true, DateUtils.getDiff(goods.getEndTime(), new Date()));
            redisUtil.decrBy("goodsId_"+order.getGoodId());
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean decrBy(Long goods) {

        if (goodsMapper.decrBy(goods) > 0) {
            return true;
        }
        return false;
    }
}
