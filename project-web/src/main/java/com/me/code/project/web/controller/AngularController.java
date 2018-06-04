package com.me.code.project.web.controller;

import com.me.code.project.service.util.JSONUtil;
import com.me.code.project.service.vo.ConditionVo;
import com.me.code.project.service.vo.PageVo;
import com.me.code.project.service.vo.ResultVo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhull
 * @date 2018/3/27
 * <P></P>
 */
@Slf4j
@Controller
public class AngularController {

    @RequestMapping("/sealed")
    @ResponseBody
    public PageVo hello(@RequestParam("pageSize") Integer pageSize,
                        @RequestParam("page") Integer currentPage,
                        @RequestParam("args") String args
                        ) {
        log.info("Gotcha !");

        ConditionVo reqVo = JSONUtil.fromJson(args, ConditionVo.class);
        try {
            // todo 不起效
            if (reqVo != null && !StringUtils.isEmpty(reqVo.getName())) {
                reqVo.setName(new String(reqVo.getName().getBytes(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // 结果
        List<ResultVo> list = new ArrayList<>();
        ResultVo resultVo0 = new ResultVo();
        resultVo0.setAttachmentState(0);
        resultVo0.setMortgagorName("抵押人0");
        resultVo0.setNoticeTime(new Date());
        resultVo0.setSit("这里");
        list.add(resultVo0);
        ResultVo resultVo1 = new ResultVo();
        resultVo1.setAttachmentState(1);
        resultVo1.setMortgagorName("抵押人1");
        resultVo1.setNoticeTime(new Date());
        resultVo1.setSit("这里1");
        list.add(resultVo1);
        ResultVo resultVo2 = new ResultVo();
        resultVo2.setAttachmentState(2);
        resultVo2.setMortgagorName("抵押人2");
        resultVo2.setNoticeTime(new Date());
        resultVo2.setSit("这里2");
        list.add(resultVo2);
        PageVo<ResultVo> page = new PageVo<>();
        page.setCurrentPage(1);
        page.setTotalPage(2);
        page.setTotal(5);
        page.setDataList(list);

        String json = JSONUtil.toJson(page);
        log.info("{}", json);
//        return json;
        JSONObject result = new JSONObject();
        result.put("results", json);
//        return result.toString();
        return page;
    }

    @RequestMapping("reSend")
    @ResponseBody
    public String reSend(@RequestParam("args") String args) {
        log.info("reSend, {}", args);
        Message message = new Message();
        message.setCode(1);
        message.setDesc("成功");

        String json = JSONUtil.toJson(message);
        return json;
    }

    @Data
    public static class Message {
        private Integer code;
        private String desc;
    }
}