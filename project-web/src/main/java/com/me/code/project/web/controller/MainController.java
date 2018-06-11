package com.me.code.project.web.controller;

import com.me.code.project.service.vo.UserResVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author zhull
 * @date 2018/3/16
 * <P>业务控制层</P>
 */
@Slf4j
@Controller
@RequestMapping("/main")
public class MainController extends BaseController {

    @ApiOperation(value="首页", notes = "")
    @RequestMapping("/index")
    public ModelAndView goIndex(HttpServletRequest request) {
        log.info("进入首页...");
        Map<String, Object> map = new HashMap<>(1);
        map.put("name", "ali");
        map.put("time", new Date());
        return new ModelAndView("index", map);
    }

    /**
     * 测试get方法
     */
    @ApiOperation(value="测试get方法", notes = "method = RequestMethod.GET")
    @RequestMapping("/getValue/{message}")
    @ResponseBody
    public String getValue(@PathVariable("message") String message, String code) {
        log.info("code = {}, message = {}", code, message);
        return "get到了！";
    }

    /**
     * 测试post方法
     */
    @ApiOperation("测试post方法")
    @ApiImplicitParam(name = "message", value = "页面消息", dataType = "String")
    @RequestMapping(value = "/postValue", method = RequestMethod.POST)
    @ResponseBody
    public String postValue(String message) {
        log.info("post a message = {}", message);
        return "post到了！";
    }

    /**
     * 测试ajax方法
     */
    @ApiOperation(value="测试ajax方法", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "time", value = "时间", required = false, dataType = "Date"),
            @ApiImplicitParam(name = "name", value = "名字", required = true, dataType = "String")
    })
    @RequestMapping(value = "/ajaxMethod", method = RequestMethod.POST)
    @ResponseBody
    public String ajaxMethod(Date time, @RequestParam("name") String name) {
        log.info("name = {}, time = {}", name, time);
        UserResVo resVo = new UserResVo();
        resVo.setName(name);
        return name;
    }

    /**
     * 联动
     */
    @RequestMapping(value = "/getNums", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> getNums(Integer type) throws Exception {
        log.info("type = {}", type);
        List<Integer> nums = new ArrayList<>();
        if (type == 0) {
            nums.add(1);
            nums.add(3);
        } else if (type == 1) {
            nums.add(2);
            nums.add(4);
        }
        if (type == 3) {
            throw new Exception("出错了");
        }
        return nums;
    }
}
