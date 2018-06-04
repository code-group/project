package com.me.code.project.service.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhull
 * @date 2018/3/29
 * <P>查询条件</P>
 */
@Data
public class ConditionVo {
    /**
     * 姓名
     */
    private String name;

    /**
     * 证件号
     */
    private String idCard;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 开始时间
     */
    private Date created_begin;

    /**
     * 结束时间
     */
    private Date created_end;
}
