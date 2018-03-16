package com.me.code.project.service.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhull
 * @date 2018/3/16
 * <P>用户订单</P>
 */
@Data
public class UserOrderResVo {
    /**
     * <pre>
     * 姓名
     * 表字段： USER.NAME
     * </pre>
     *
     */
    private String name;

    /**
     * <pre>
     * 物理主键
     * 表字段： ORDER_INFO.ID
     * </pre>
     *
     */
    private Integer orderId;

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
