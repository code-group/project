package com.me.code.project.service.util;

import java.math.BigDecimal;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   liufeng8
 * <p>UPDATE BY:   liufeng8
 * <p>CREATE DATE: 6/5 0005
 * <p>UPDATE DATE: 6/5 0005
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class BigDecimalUtils {

    /**
     * 保留俩位有效数据并四舍五入
     *
     * @param paramBD
     * @return
     */
    public static BigDecimal roundingAnd2validData(BigDecimal paramBD) {
        return paramBD != null ? paramBD.setScale(2, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
    /**
     * 保留俩位有效数据并四舍五入
     *
     * @param paramBDStr
     * @return
     */
    public static BigDecimal roundingAnd2validData(String paramBDStr) {
        BigDecimal paramBD = new BigDecimal(paramBDStr);
        return paramBD != null ? paramBD.setScale(2, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
