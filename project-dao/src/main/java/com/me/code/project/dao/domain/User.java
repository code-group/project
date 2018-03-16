package com.me.code.project.dao.domain;

import lombok.Data;

@Data
public class User {
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

}