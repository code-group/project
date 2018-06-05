package com.me.code.project.dao.mapper;

import com.me.code.project.dao.bo.UserOrderBo;
import com.me.code.project.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);


    /**
     * 记录总数
     */
    Integer count(User user);

    /**
     * 分页数据
     */
    List<User> listUser(@Param("user") User user,
                        @Param("startIndex") Integer startIndex,
                        @Param("pageSize") Integer pageSize);

    /**
     * 查询用户的所有订单
     */
    List<UserOrderBo> listUserOrder(User user);

    /**
     * 批量操作
     * 调用的时候注意限制list大小，
     * mysql有最大sql长度限制，建议1000条执行一次，用事务控制
     */


    /**
     * 根据状态更新
     */
    int updateByStatus(User user);
}