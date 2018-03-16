package com.me.code.project.common.data;

import lombok.Data;

import java.io.Serializable;

/**
 * 消息对象，通用于通讯层的封装
 */
@Data
public class Message<D> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 结果。
     */
    private Result result;
    /**
     * 编码(可表示错误码等)。
     */
    private int code;
    /**
     * 错误信息编码(可表示错误码等)。
     */
    private String message;
    /**
     * 数据。
     */
    private D data;

    public Message() {
    }

    public Message(Result result, int code) {
        super();
        this.result = result;
        this.code = code;
    }

    public Message(Result result, Integer code, String message) {
        super();
        this.result = result;
        this.code = code;
        this.message = message;
    }

    public Message(Result result, int code, String message, D data) {
        super();
        this.result = result;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Message(Result result, D data) {
        super();
        this.result = result;
        this.data = data;
    }

    public Message(Result result, int code, D data) {
        super();
        this.result = result;
        this.code = code;
        this.data = data;
    }
}
