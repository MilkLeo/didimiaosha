package didimiaosha.miaosha.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import didimiaosha.miaosha.entity.User;

public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}