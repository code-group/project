package com.me.code.project.test;

import com.me.code.project.dao.domain.User;
import com.me.code.project.dao.mapper.UserMapper;
import com.me.code.project.service.UserService;
import com.me.code.project.service.data.Page;
import com.me.code.project.service.vo.UserOrderResVo;
import com.me.code.project.service.vo.UserReqVo;
import com.me.code.project.service.vo.UserResVo;
import com.me.code.project.web.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author zhull
 * @date 2018/3/15
 * <P>测试类</P>
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
public class UserTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryPage() {
        UserReqVo reqVo = new UserReqVo();
        Page<UserResVo> page = userService.queryPage(reqVo);
    }

    @Test
    public void testQueryUserOrder() {
        UserReqVo reqVo = new UserReqVo();
        List<UserOrderResVo> resVos = userService.queryUserOrder(reqVo);
        log.info("{}", resVos);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(1);
        user.setStatus((byte) 1);
        user.setName("小明");
        int result = userMapper.updateByStatus(user);
        System.out.println(result);
    }
}
