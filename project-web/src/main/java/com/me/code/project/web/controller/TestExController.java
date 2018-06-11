package com.me.code.project.web.controller;

import com.me.code.project.web.handler.GlobalExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhull
 * @date 2018/4/18
 * <P>测试全局异常处理</P>
 *
 * @see GlobalExceptionHandler
 */
@Slf4j
@Controller
@RequestMapping("/exp")
public class TestExController extends BaseController {

    @GetMapping("/any")
    public String testEx() {
        log.error("我是异常");
        throw new RuntimeException("我是异常");
    }

}
