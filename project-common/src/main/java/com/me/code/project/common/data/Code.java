package com.me.code.project.common.data;

/**
 * Message的编码枚举
 */
public enum Code {

    /**
     * 成功。
     */
    SUCCESS(200),

    /**
     * 失败。
     */
    FAIL(300),

    /**
     * 系统异常
     */

    SYSTEM_EXCEPTION(1000),

    /**
     * 调用服务失败
     */

    CALL_EXCEPTION(1101),

    /**
     * 参数不合法
     */
    PARAMATER_INVALID(2000),

    /**
     * 查询结果集为空
     */
    RESULTSET_IS_NULL(2001);

    private int value;

    Code(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
