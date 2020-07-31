package didimiaosha.miaosha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import didimiaosha.miaosha.entity.Order;

public interface OrderMapper extends BaseMapper<Order> {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}