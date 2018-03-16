package com.me.code.project.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhull
 * @date 2018/3/16
 * <P>业务控制层</P>
 */
@Slf4j
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @RequestMapping("/index")
    public ModelAndView goIndex(HttpServletRequest request) {
        log.info("进入首页...");
        Map<String, Object> map = new HashMap(1);
        map.put("name", "ali");
        map.put("time", new Date());
        return new ModelAndView("index", map);
    }

    @RequestMapping("/getValue/{message}")
    @ResponseBody
    public String getValue(@PathVariable("message") String message, String code) {
        log.info("code = {}, message = {}", code, message);
        return "get到了！";
    }

    @RequestMapping(value = "/postValue", method = RequestMethod.POST)
    @ResponseBody
    public String postValue(String message) {
        log.info("post a message = {}", message);
        return "post到了！";
    }
}
