package com.xnyesf.opinion.util.time;

import java.time.*;
import java.util.Calendar;
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

    private static final int LAST_MONTH_TO_SUB = 1;

    private static final int BEFORE_LAST_MONTH_TO_SUB = 2;
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

    /**
     * 获取上个月的开始日期
     * @return 上个月开始日期
     */
    public static Date getLastMonthStartDate() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfLastMonth = now.minusMonths(LAST_MONTH_TO_SUB).withDayOfMonth(FIRST_MONTH_DAY);
        LocalDateTime lastMonthStartTime = firstDayOfLastMonth.atStartOfDay();
        Instant lastMonthStartTimeInstant = lastMonthStartTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(lastMonthStartTimeInstant);
    }

    /**
     * 获取上个月结束日期
     * @return 上个月结束日期
     */
    public static Date getLastMonthEndDate() {
        LocalDate now = LocalDate.now();
        LocalDate lastDayOfLastMonth = now.minusMonths(LAST_MONTH_TO_SUB).withDayOfMonth(now.minusMonths(LAST_MONTH_TO_SUB).lengthOfMonth());
        LocalDateTime lastMonthEndTime = lastDayOfLastMonth.atTime(LocalTime.MAX);
        Instant lastMonthEndTimeInstant = lastMonthEndTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(lastMonthEndTimeInstant);
    }

    /**
     * 获取本日开始时间
     * @return
     */
    public static Date getCurrentDayStartDate() {
        LocalDate today = LocalDate.now();
        LocalDateTime startOfDay = today.atStartOfDay();
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取本日结束时间
     * @return
     */
    public static Date getCurrentDayEndDate() {
        LocalDate today = LocalDate.now();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 重置任意时间为当天开始时间
     * @param date 日期
     * @return 日期当天开始时间
     */
    public static Date reset2StartOfDay(Date date){
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 重置任意时间为当天结束时间
     * @param date 日期
     * @return 日期当天结束时间
     */
    public static Date reset2EndOfDay(Date date){
        if (date == null) {
            return null;
        }
        LocalDateTime localDateTime = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime()
                .with(LocalTime.MAX);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 将输入日期向前推day天
     * @param date
     * @param day
     * @return
     */
    public static Date subDate(Date date, int day) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        return calendar.getTime();
    }

    /**
     * 获取上上个月的开始日期
     * @return 上上个月开始日期
     */
    public static Date getBeforeLastMonthStartDate() {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfBeforeLastMonth = now.minusMonths(BEFORE_LAST_MONTH_TO_SUB).withDayOfMonth(FIRST_MONTH_DAY);
        LocalDateTime beforeLastMonthStartTime = firstDayOfBeforeLastMonth.atStartOfDay();
        Instant beforeLastMonthStartTimeInstant = beforeLastMonthStartTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(beforeLastMonthStartTimeInstant);
    }

    /**
     * 获得上上个月的结束日期
     * @return 上上个月的结束日期
     */
    public static Date getBeforeLastMonthEndDate() {
        LocalDate now = LocalDate.now();
        LocalDate lastDayOfBeforeLastMonth = now.minusMonths(BEFORE_LAST_MONTH_TO_SUB)
                .withDayOfMonth(now.minusMonths(BEFORE_LAST_MONTH_TO_SUB).lengthOfMonth());
        return Date.from(lastDayOfBeforeLastMonth.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得距今任意一个月的开始时间
     * @param distanceMonth 月份
     * @return 月开始时间
     */
    public static Date getDistanceMonthStartDate(int distanceMonth) {
        LocalDate now = LocalDate.now();
        LocalDate firstDayOfBeforeLastMonth = now.minusMonths(distanceMonth).withDayOfMonth(FIRST_MONTH_DAY);
        LocalDateTime beforeLastMonthStartTime = firstDayOfBeforeLastMonth.atStartOfDay();
        Instant beforeLastMonthStartTimeInstant = beforeLastMonthStartTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(beforeLastMonthStartTimeInstant);

    }


    /**
     * 获得距今任意一个月的结束时间
     * @param distanceMonth 月份
     * @return 月结束时间
     */
    public static Date getDistanceMonthEndDate(int distanceMonth) {
        LocalDate now = LocalDate.now();
        LocalDate lastDayOfBeforeLastMonth = now.minusMonths(distanceMonth)
                .withDayOfMonth(now.minusMonths(distanceMonth).lengthOfMonth());
        return Date.from(lastDayOfBeforeLastMonth.atTime(LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant());

    }
}
