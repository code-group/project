package com.me.code.project.service.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhull
 * @date 2018/3/15
 * <P>用户信息返参</P>
 */
@Data
public class UserResVo {
    /**
     * <pre>
     * 物理主键
     * 表字段： USER.ID
     * </pre>
     *
     */
    private Integer id;

    /**
     * <pre>
     * 姓名
     * 表字段： USER.NAME
     * </pre>
     *
     */
    private String name;

    /**
     * 时间
     */
    private Date time;
}
