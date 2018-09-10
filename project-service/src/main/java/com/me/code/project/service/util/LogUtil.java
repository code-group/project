package com.me.code.project.service.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhull
 * @date 2018/9/10
 * <P>日志包裹工具</P>
 */
@Slf4j
public class LogUtil {

    public static <P, D> D exec(Task<P, D> t, P param, String info) {
        log.info("{}, req param = {}", info, param);
        try {
            D res = t.exec(param);
            log.info("{}, req param = {}, res param = {}", info, param, res);
        } catch (Exception e) {
            log.error("{}, exception", info, e);
        }
        return null;
    }

    public interface Task<P, D> {
        D exec(P param);
    }

    /**--------------------- 以下为测试方法, 需要@Test测试 ---------------------**/
    public static void main(String[] args) {
        String param = "hello";
        LogUtil.exec(param1 -> {
            System.out.println("hh");
            return 1;
        }, param, "测试程序1");

        LogUtil.exec(LogUtil::print, param, "测试程序2");
    }

    public static Integer print(String a) {
        System.out.println(a + " world!");
        return 1;
    }
}
