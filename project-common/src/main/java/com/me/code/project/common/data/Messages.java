package com.me.code.project.common.data;

import com.me.code.project.common.exceptions.BaseException;

/**
 * Message的工具类
 */
public class Messages {

    /**
     * 构造一个成功的消息。
     *
     * @param data 数据。
     * @return 消息实例。
     */
    public static <D> Message<D> success(D data) {
        return new Message<D>(Result.SUCCESS, Code.SUCCESS.getValue(), data);
    }

    /**
     * 构造一个不带数据的成功的消息。
     *
     * @return 消息实例。
     */
    public static <D> Message<D> success() {
        return success(null);
    }

    /**
     * 构造一个失败的消息。 表示逻辑上失败
     *
     * @param code 编码,表示失败原因。
     * @return 消息实例。
     */
    public static <D> Message<D> failed(int code) {
        return new Message<D>(Result.FAILED, code);
    }

    /**
     * 构造一个失败的消息。 表示逻辑上失败
     *
     * @param code 编码,表示失败原因。
     * @param msg  错误信息
     * @return 消息实例。
     */
    public static <D> Message<D> failed(int code, String msg) {
        return new Message<D>(Result.FAILED, code, msg);
    }

    /**
     * 构造一个错误的消息。
     *
     * @return 消息实例。表示错误
     */
    public static <D> Message<D> error() {
        return new Message<D>(Result.ERROR, null);
    }

    /**
     * 构造一个带错误错误的消息。
     *
     * @return 消息实例。表示错误
     */
    public static <D> Message<D> error(int code) {
        return new Message<D>(Result.ERROR, code);
    }

    /**
     * 判断消息是否成功
     *
     * @return 成功真值。
     */

    public static boolean isSuccess(Message<?> message) {

        if (Result.SUCCESS.equals(message.getResult())) {
            return true;
        }
        return false;
    }

    private Messages() {
    }


    /**
     * 从message中拿到数据或抛出异常.
     *
     * @param msg message 对象
     * @param <D> message中的data类型
     * @return message中的data
     */
    public static <D> D getDataOrThrowBaseException(final Message<D> msg) {
        if (Messages.isSuccess(msg)) {
            return msg.getData();
        } else {
            throw new BaseException(msg.getCode(), msg.getMessage());
        }
    }
}
