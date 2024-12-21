package com.xnyesf.opinion.util.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author CaoLiangBin
 * @date 2024年12月21日 10:36
 * @description 时间管理工具类
 */
public class TimeCommonUtil {

    private static final int FIRST_MONTH_DAY = 1;

    private static final int END_HOUR = 23;

    private static final int END_MINUTE = 59;

    private static final int END_SECOND = 59;

    private static final int MONTH_TO_SUB = 1;
    /**
     * 获取当前月份的开始日期
     *
     * @return 当前月份的开始日期
     */
    public static Date getCurrentMonthStartDate() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfMonth = now.withDayOfMonth(FIRST_MONTH_DAY);
        LocalDateTime monthStartTime = firstDayOfMonth.atStartOfDay();
        Instant monthStartTimeInstant = monthStartTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(monthStartTimeInstant);
    }

    /**
     * 获取当前月份的结束日期
     * @return 当前月份的结束日期
     */
    public static Date getCurrentMonthEndDate() {
        LocalDate now = LocalDate.now();
        LocalDate lastDayOfMonth = now.withDayOfMonth(now.lengthOfMonth());
        LocalDateTime monthEndTime = lastDayOfMonth.atTime(END_HOUR, END_MINUTE, END_SECOND);
        Instant monthEndTimeInstant = monthEndTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(monthEndTimeInstant);
    }

    public static Date getLastMonthStartDate() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfLastMonth = now.minusMonths(MONTH_TO_SUB).withDayOfMonth(FIRST_MONTH_DAY);
        LocalDateTime lastMonthStartTime = firstDayOfLastMonth.atStartOfDay();
        Instant lastMonthStartTimeInstant = lastMonthStartTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(lastMonthStartTimeInstant);
    }

    public static Date getLastMonthEndDate() {
        LocalDate now = LocalDate.now();
        LocalDate lastDayOfLastMonth = now.minusMonths(MONTH_TO_SUB).withDayOfMonth(now.minusMonths(1).lengthOfMonth());
        LocalDateTime lastMonthEndTime = lastDayOfLastMonth.atTime(END_HOUR, END_MINUTE, END_SECOND);
        Instant lastMonthEndTimeInstant = lastMonthEndTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(lastMonthEndTimeInstant);
    }
}
