package didimiaosha.miaosha.service;

import didimiaosha.miaosha.entity.Order;

public interface IRabbitmqService {


    /**
     *@description 秒杀创建订单
     *@param
     *@return
     *@author suewong
     *@date 2020/7/30 14:29
    */
    void createOrder(Order order);


    /**
     *@description 修改库存
     *@param
     *@return
     *@author suewong
     *@date 2020/7/30 14:30
    */
    void decrBy(Long goodsId);
}
