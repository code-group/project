package com.me.code.project.web.controller;

import com.me.code.project.service.util.MailUtil;
import com.me.code.project.service.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhull
 * @date 2018/6/1
 * <P></P>
 */
@Slf4j
@RestController
@RequestMapping("/mail")
public class MailController extends BaseController {

    @Autowired
    private MailUtil mailUtil;

    private static String SUCCESS = "success";


    @Value("${spring.mail.username}")
    private String sendUsername;

    @GetMapping("/send")
    public String send() throws MessagingException {

        String errorMessage;
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            Writer writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            errorMessage = writer.toString();
        }
        Map<String, Object> data = new HashMap<>();
        data.put("username", "Ali");
        data.put("methodName", "send");
        data.put("errorMessage", errorMessage);
        data.put("occurredTime", new Date());

        MailVo mailVo = new MailVo();
        mailVo.setSendUsername(sendUsername);
        mailVo.setReceivers(new String[] {"zhulili@ginkgofit.com"});
        mailVo.setSubject("测试");
        mailVo.setHtml(false);
        mailVo.setContent("morning~");
        mailVo.setTemplate(false);
        mailUtil.sendMail(mailVo);
        return SUCCESS;
    }
}
