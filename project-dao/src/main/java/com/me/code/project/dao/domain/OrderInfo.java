package com.me.code.project.dao.domain;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    /**
     * <pre>
     * 物理主键
     * 表字段： ORDER_INFO.ID
     * </pre>
     * 
     */
    private Integer id;

    /**
     * <pre>
     * 用户ID
     * 表字段： ORDER_INFO.USER_ID
     * </pre>
     * 
     */
    private Integer userId;

    /**
     * <pre>
     * 订单描述
     * 表字段： ORDER_INFO.DESCRIPTION
     * </pre>
     * 
     */
    private String description;

    /**
     * <pre>
     * 创建时间
     * 表字段： ORDER_INFO.GMT_CREATE
     * </pre>
     * 
     */
    private Date gmtCreate;

}