package com.me.code.project.service.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhull
 * @date 2018/3/29
 * <P></P>
 */
@Data
public class ResultVo {
    /**
     * 坐落
     */
    private String sit;
    /**
     * 查封状态
     */
    private Integer attachmentState;
    /**
     * 抵押人姓名
     */
    private String mortgagorName;
    /**
     * 通知时间
     */
    private Date noticeTime;
}
