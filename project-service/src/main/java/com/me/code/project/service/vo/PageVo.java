package com.me.code.project.service.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author zhull
 * @date 2018/3/29
 * <P></P>
 */
@Data
public class PageVo<T> implements Serializable {

    private Integer currentPage;

    private Integer totalPage;

    private Integer total;

    private List<T> dataList;
}
