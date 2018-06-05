package com.me.code.project.service;

import com.google.common.collect.Lists;
import com.me.code.project.dao.bo.UserOrderBo;
import com.me.code.project.dao.domain.User;
import com.me.code.project.dao.mapper.UserMapper;
import com.me.code.project.service.data.Page;
import com.me.code.project.service.vo.UserOrderResVo;
import com.me.code.project.service.vo.UserReqVo;
import com.me.code.project.service.vo.UserResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhull
 * @date 2018/3/15
 * <P>User服务类</P>
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 分页查询
     */
    public Page<UserResVo> queryPage(UserReqVo reqVo) {
        log.info("{}", reqVo);
        User user = new User();
        BeanUtils.copyProperties(reqVo, user);
        Page<UserResVo> page = new Page<>();
        page.setTotalCount(userMapper.count(user));
        List<User> users = userMapper.listUser(user, reqVo.getStartIndex(), reqVo.getPageSize());
        List<UserResVo> resVos = Lists.transform(users, userD -> {
            UserResVo resVo = new UserResVo();
            BeanUtils.copyProperties(userD, resVo);
            return resVo;
        });
        page.setDataList(resVos);
        log.info("{}", page);
        return page;
    }

    /**
     * 查询用户订单
     */
    public List<UserOrderResVo> queryUserOrder(UserReqVo reqVo) {
        log.info("查询用户订单入参, {}", reqVo);
        User user = new User();
        BeanUtils.copyProperties(reqVo, user);
        List<UserOrderBo> bos = userMapper.listUserOrder(user);
        List<UserOrderResVo> resVos = Lists.transform(bos, bo -> {
            UserOrderResVo resVo = new UserOrderResVo();
            BeanUtils.copyProperties(bo, resVo);
            return resVo;
        });
        log.info("查询用户订单返参, {}", resVos);
        return resVos;
    }

}
