package com.me.code.project.service.util;

import com.me.code.project.common.exceptions.BaseException;
import com.me.code.project.common.utils.ValidateUtil;
import com.me.code.project.service.vo.MailVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author zhull
 * @date 2018/6/8
 * <P>发送邮件</P>
 */
@Component
@Slf4j
public class MailUtil {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;

    /**
     * 发送邮件
     * @param mailVo
     */
    public void sendMail(MailVo mailVo) throws MessagingException {
        ValidateUtil.validateAll(mailVo);
        if (mailVo.isTemplate()) {
            if (StringUtils.isEmpty(mailVo.getContent())) {
                throw new BaseException("邮件模板名称为空");
            }
            Context context = new Context();
            if (mailVo.getTemplateData() != null) {
                for (String key : mailVo.getTemplateData().keySet()) {
                    context.setVariable(key, mailVo.getTemplateData().get(key));
                }
                mailVo.setContent(templateEngine.process(mailVo.getTemplateName(), context));
            }
        }
        if (StringUtils.isEmpty(mailVo.getContent())) {
            throw new BaseException("邮件内容为空");
        }
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom(mailVo.getSendUsername());
        mimeMessageHelper.setTo(mailVo.getReceivers());
        if (mailVo.getCcs() != null) {
            mimeMessageHelper.setCc(mailVo.getCcs());
        }
        if (mailVo.getBccs() != null) {
            mimeMessageHelper.setBcc(mailVo.getBccs());
        }
        mimeMessageHelper.setSubject(mailVo.getSubject());
        mimeMessageHelper.setText(mailVo.getContent(), mailVo.isHtml());
        if (mailVo.getFiles() != null && mailVo.getFiles().length > 0) {
            for (File file : mailVo.getFiles()) {
                mimeMessageHelper.addAttachment(file.getName(), file);
            }
        }
        mailSender.send(message);
    }
    /**
     * 发送简单邮件
     * @param mailVo
     */
    private void sendSimple(MailVo mailVo){
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom(mailVo.getSendUsername());
        mail.setTo(mailVo.getReceivers());
        mail.setCc(mailVo.getCcs());
        mail.setBcc(mailVo.getBccs());
        mail.setSubject(mailVo.getSubject());
        mail.setText(mailVo.getContent());
        mailSender.send(mail);
    }

}
