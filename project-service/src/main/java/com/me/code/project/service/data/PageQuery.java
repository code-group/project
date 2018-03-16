package com.me.code.project.service.data;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhull
 * @date 2018/3/15
 * <P>分页查询通用参数</P>
 */
@Data
public class PageQuery implements Serializable {
    private static final long serialVersionUID = -8364559027609347594L;

    /**
     * 当前页面
     */
    private Integer currentPage = 1;

    /**
     * 页面大小
     */
    private Integer pageSize = 10;

    /**
     * 计算记录起始位置
     * @return startIndex
     */
    public Integer getStartIndex() {
        return (currentPage - 1) * pageSize;
    }
}
