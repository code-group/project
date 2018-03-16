package com.me.code.project.service.vo;

import com.me.code.project.service.data.PageQuery;
import lombok.Data;

/**
 * @author zhull
 * @date 2018/3/15
 * <P>用户信息请求参数</P>
 */
@Data
public class UserReqVo extends PageQuery {
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

    @Override
    public String toString() {
        return super.toString() + ", UserReqVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
