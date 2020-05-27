package com.example.common.utils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间偏移量计算
 *
 * @author ZKTT
 */
public class DateUtils {

    /**
     * 给定的时间，按照分钟进行偏移
     *
     * @param date   给定的时间
     * @param offset 偏移量
     * @return 偏移后的时间
     */
    public static Date modifiyMinute(Date date, int offset) {
        return modifiyDate(date, Calendar.MINUTE, offset);
    }

    /**
     * 给定的时间，按照秒进行偏移
     *
     * @param date   给定的时间
     * @param offset 偏移量
     * @return 偏移后的时间
     */
    public static Date modifiySecond(Date date, int offset) {
        return modifiyDate(date, Calendar.SECOND, offset);
    }

    /**
     * 给定的时间，按照小时进行偏移
     *
     * @param date   给定的时间
     * @param offset 偏移量
     * @return 偏移后的时间
     */
    public static Date modifiyHour(Date date, int offset) {
        return modifiyDate(date, Calendar.HOUR_OF_DAY, offset);
    }

    /**
     * 给定的时间，按照年份进行偏移
     *
     * @param date   给定的时间
     * @param offset 偏移量
     * @return 偏移后的时间
     */
    public static Date modifiyYear(Date date, int offset) {
        return modifiyDate(date, Calendar.YEAR, offset);
    }

    /**
     * 给定的时间，按照月份进行偏移
     *
     * @param date   给定的时间
     * @param offset 偏移量
     * @return 偏移后的时间
     */
    public static Date modifiyMonth(Date date, int offset) {
        return modifiyDate(date, Calendar.MONTH, offset);
    }

    /**
     * 给定的时间，按照天数进行偏移
     *
     * @param date   给定的时间
     * @param offset 偏移量
     * @return 偏移后的时间
     */
    public static Date modifiyDayOfMonth(Date date, int offset) {
        return modifiyDate(date, Calendar.DAY_OF_MONTH, offset);
    }

    /**
     * 给定时间，按照指定的类型进行偏移
     *
     * @param date          给定的时间
     * @param calendarFiled 指定的偏移类型（年 或 月 或 日 等等）
     * @param offset        偏移量
     * @return 偏移后的时间
     */
    private static Date modifiyDate(Date date, int calendarFiled, int offset) {
        if (date == null) {
            throw new IllegalArgumentException("传递的时间有误");
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendarFiled, offset);
        return new Date(calendar.getTimeInMillis());
    }

    public static int daysBetween(Date smdate, Date bdate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));

    }

   /* public static void main(String[] args) throws ParseException {
        String date = "2020-04-25 11:43:23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1 = modifiyMinute(sdf.parse(date), 10);
        daysBetween(date,date1);
        System.out.println(sdf.format(date1));
    }*/
}
