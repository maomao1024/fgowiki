package com.github.fgowiki.spider.utils;

import java.math.BigDecimal;

/**
 * 转换工具类
 *
 * @author jiang
 * @create 2017-11-27 21:31
 **/
public class ObjectUtil {

    public static Integer convernToInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String convernToString(Object obj) {
        return obj == null ? null : obj.toString();
    }

    public static Integer convernToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return Integer.parseInt(obj.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static BigDecimal convernToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return new BigDecimal(obj.toString());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String getStringBylength(String s, int count) {
        if (count > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(s);
            }
            return sb.toString();
        }
        return "";
    }
}
