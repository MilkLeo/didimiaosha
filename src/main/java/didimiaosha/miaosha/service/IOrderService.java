package didimiaosha.miaosha.service;

import didimiaosha.miaosha.entity.Order;

public interface IOrderService {


    /**
     *@description 创建订单
     *@param
     *@return
     *@author suewong
     *@date 2020/7/30 14:09
    */
    boolean createOrder(Order order) throws Exception;



    /**
     *@description 减少库存
     *@param
     *@return
     *@author suewong
     *@date 2020/7/30 14:40
    */
    boolean decrBy(Long goods);
}
