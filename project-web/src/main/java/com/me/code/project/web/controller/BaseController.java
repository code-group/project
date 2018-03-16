package com.me.code.project.web.controller;

import com.me.code.project.common.data.Message;
import com.me.code.project.common.data.Messages;
import com.me.code.project.common.exceptions.BaseException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基础控制层类
 */
public class BaseController {

    /**
     * spmvc将表单和对象绑定日期类型转换
     *
     * @param binder 绑定器
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    /**
     * 从message中拿到数据或抛出异常.
     *
     * @param msg message 对象
     * @param <D> message中的data类型
     * @return message中的data
     */
    protected <D> D getDataOrThrowBaseException(final Message<D> msg) {
        if (Messages.isSuccess(msg)) {
            return msg.getData();
        } else {
            throw new BaseException(msg.getCode(), msg.getMessage());
        }
    }
}
