package didimiaosha.miaosha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import didimiaosha.miaosha.entity.Goods;
import org.apache.ibatis.annotations.Param;

public interface GoodsMapper extends BaseMapper<Goods> {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    int decrBy(@Param("goodsId") Long goodsId);
}