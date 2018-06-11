package com.me.code.project.web.handler;

import com.me.code.project.common.exceptions.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhull
 * @date 2018/4/18
 * <P>全局异常处理器</P>
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String LOG_PREFIX = "global exception: ";

    /**
     * 处理自定义异常
     * ajax返回
     */
    @ExceptionHandler(value = {BaseException.class})
    @ResponseBody
    public String baseExceptionHandler(BaseException e) {
        log.error("{}", LOG_PREFIX, e);

//        return "{'code':-1}";
        return "error";
    }

    /**
     * 处理所有异常
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(Exception e) {
        log.error("{}", LOG_PREFIX, e);
        return new ModelAndView("/error");
    }
}
