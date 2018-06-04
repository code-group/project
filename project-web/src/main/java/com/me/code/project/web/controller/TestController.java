package com.me.code.project.web.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhull
 * @date 2018/6/1
 * <P></P>
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/retry")
    public void testRecovery() {
        TestVo reqVo = new TestVo();
        reqVo.setName("222");
        TestController bean1 = applicationContext.getBean(TestController.class);
//        TestController bean = applicationContext.getBean(getClass());
    }

    @Retryable(value = Exception.class)
    private void task(TestVo reqVo) {
        reqVo.setName("111");
        throw new RuntimeException("");
    }

    @Recover
    private void recovery(Exception e, TestVo reqVo) {
        log.info("{}", reqVo);
    }

    @Data
    private class TestVo {
        private String name;
    }
}
