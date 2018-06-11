package com.me.code.project.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @author zhull
 * @date 2018/6/8
 * <P>重试</P>
 * 在启动类中配置@EnableRetry(proxyTargetClass = true)
 */
@Slf4j
@Service
public class RetryableService {

    @Autowired
    private ApplicationContext applicationContext;

    public void testRecovery() {
        TestVo reqVo = new TestVo();
        reqVo.setName("222");
        log.info("before, {}", reqVo);
        Integer b = new Integer(3);
        String c = new String("aaa");
        applicationContext.getBean(RetryableService.class).task(reqVo, c);
    }

    /**
     * 要作为这个类的第一个入口
     * @param reqVo
     */
    @Retryable(value = Exception.class)
    public void task(TestVo reqVo, String a) {
        reqVo.setName("111");
        a = "haha";
        log.info("ing, {}", a);
        throw new RuntimeException("");
    }

    @Recover
    public void recovery(Exception e, TestVo reqVo, String a) {
        log.info("after, {}", a, e);
    }

    @Data
    public static class TestVo {
        private String name;
    }
}
