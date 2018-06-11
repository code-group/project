package com.me.code.project.service.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Map;

/**
 * @author zhull
 * @date 2018/6/8
 * <P>邮件参数</P>
 */
@Data
public class MailVo {

    /**
     * 发件人
     */
    @NotBlank
    private String sendUsername;

    /**
     * 收件人
     */
    @NotNull
    private String[] receivers;

    /**
     * 抄送人
     */
    private String[] ccs;

    /**
     * 暗抄人
     */
    private String[] bccs;

    /**
     * 主题
     */
    @NotBlank
    private String subject;

    /**
     * 使用html
     */
    @NotNull
    private boolean isHtml;

    /**
     * 内容
     * isHtml && !isTemplate || !isHtml 必填
     */
    private String content;

    /**
     * 使用模板
     */
    @NotNull
    private boolean isTemplate;

    /**
     * 模板名称
     * isTemplate 必填
     */
    private String templateName;

    /**
     * 模板数据
     */
    private Map<String, Object> templateData;

    /**
     * 附件
     */
    private File[] files;
}
