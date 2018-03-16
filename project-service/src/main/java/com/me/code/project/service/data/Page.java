package com.me.code.project.service.data;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhull
 * @date 2018/3/15
 * <P>分页数据</P>
 */
@Data
public class Page<D> implements Serializable {
    private static final long serialVersionUID = -4736775873193073904L;

    /**
     * 当前页面
     */
    private Integer currentPageNo;

    /**
     * 页面大小
     */
    private Integer pageSize;

    /**
     * 记录总数
     */
    private Integer totalCount;

    /**
     * 数据列表
     */
    private List<D> dataList;

    /**
     * 是否有下一页
     */
    public boolean hasNextPage() {
        return currentPageNo * pageSize >= totalCount ? false : true;
    }

    /**
     * 总页数
     */
    public Integer totalPage() {
        return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }
}
