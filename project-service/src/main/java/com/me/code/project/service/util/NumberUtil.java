package com.me.code.project.service.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数字操作工具类
 *
 * @author yanhuajian
 * @version V1.0
 * @date:2016年4月7日 下午1:09:39
 */
public class NumberUtil {

    /**
     * double保留两位小数
     *
     * @param value
     * @return
     * @author: yanhuajian 2016年4月7日下午1:11:41
     */
    public static String divide100Keep2(long value) {
        BigDecimal b = new BigDecimal(value);
        BigDecimal result = b.divide(new BigDecimal("100"));
        DecimalFormat myformat = new DecimalFormat("0.00");
        return myformat.format(result);
    }

    /**
     * double保留两位小数
     *
     * @param value
     * @return
     * @author: yanhuajian 2016年4月7日下午1:11:41
     */
    public static String divide100Keep2(BigDecimal value) {
        if(value == null) {
            return "0.00";
        }
        BigDecimal result = value.divide(new BigDecimal("100"));
        DecimalFormat myformat = new DecimalFormat("0.00");
        return myformat.format(result);
    }

    /**
     * 除以100 保留两位小数，带分隔符
     * @param value
     * @return
     */

    public static String divide100Keep2AndSplit(long value) {
        BigDecimal b = new BigDecimal(value);
        BigDecimal result = b.divide(new BigDecimal("100"));
        DecimalFormat myformat = new DecimalFormat(",###,##0.00");
        return myformat.format(result);
    }

    /**
     * 除以100000 保留两位小数，带分隔符
     * @param value
     * @return
     */

    public static String divide10000Keep2AndSplit(long value) {
        BigDecimal b = new BigDecimal(value);
        BigDecimal result = b.divide(new BigDecimal("10000"));
        DecimalFormat myformat = new DecimalFormat(",###,##0.00");
        return myformat.format(result);
    }
    /**
     * 除以10000000 保留两位小数，带分隔符
     * @param value
     * @return
     */

    public static String divide1000000Keep2AndSplit(String value) {
        BigDecimal b = new BigDecimal(value);
        BigDecimal result = b.divide(new BigDecimal("1000000"));
        DecimalFormat myformat = new DecimalFormat(",###,##0.00");
        return myformat.format(result);
    }
}
