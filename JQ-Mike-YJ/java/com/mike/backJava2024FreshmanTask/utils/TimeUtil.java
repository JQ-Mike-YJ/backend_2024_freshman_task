package com.mike.backJava2024FreshmanTask.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间转换工具
 */
public class TimeUtil {

    /**
     * 工具类构造方法私有化
     */
    private TimeUtil() {
    }

    /**
     * String 转 LocalDateTime
     *
     * @param timeStr 时间字符串
     * @param pattern 样式
     * @return LocalDateTime
     */
    public static LocalDateTime getStrLocalDateTime(String timeStr, String pattern) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(timeStr, fmt);
    }

    /**
     * LocalDateTime 转 String
     *
     * @param localDateTime localDateTime
     * @param pattern       样式
     * @return String
     */
    public static String getLocalDateTimeStr(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(fmt);
    }
}
