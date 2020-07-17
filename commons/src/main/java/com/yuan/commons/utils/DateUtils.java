/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yuan.commons.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类, 继承org.apache.commons.lang.time.DateUtils类
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @Author:zhenganke
     * @Description: 得到日期时间字符串，转换格式(yyyyMMddHHmmss),用作需求追踪编号
     * @Date: 2017/12/22
     */
    public static String formatDateTimeTrack(Date date) {
        return formatDate(date, "yyyyMMddHHmmss");
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd）
     */
    public static String formatDateTimeMobile(Date date){
        return formatDate(date,"yyyy-MM-dd");
    }
    /**
     * 得到当前时间字符串 格式（HH:mm:ss）
     */
    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    /**
     * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 得到当前年份字符串 格式（yyyy）
     */
    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    /**
     * 得到当前月份字符串 格式（MM）
     */
    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    /**
     * 得到当天字符串 格式（dd）
     */
    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    /**
     * 得到当前星期字符串 格式（E）星期几
     */
    public static String getWeek() {
        return formatDate(new Date(), "E");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取过去的天数
     * @param date
     * @return
     */
    public static long pastDays(Date date) {
        long t = new Date().getTime()-date.getTime();
        return t/(24*60*60*1000);
    }

    /**
     * 获取过去的小时
     * @param date
     * @return
     */
    public static long pastHour(Date date) {
        long t = new Date().getTime()-date.getTime();
        return t/(60*60*1000);
    }

    /**
     * 获取过去的分钟
     * @param date
     * @return
     */
    public static long pastMinutes(Date date) {
        long t = new Date().getTime()-date.getTime();
        return t/(60*1000);
    }

    /**
     * 转换为时间（天,时:分:秒.毫秒）
     * @param timeMillis
     * @return
     */
    public static String formatDateTime(long timeMillis){
        long day = timeMillis/(24*60*60*1000);
        long hour = (timeMillis/(60*60*1000)-day*24);
        long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
        long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
        long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
        return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }

    /**
     * 获取两个日期之间的天数
     *
     * @param before
     * @param after
     * @return
     */
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }


    /**
     * 今天剩余秒数
     * @return
     */
    public static int getTodayOverplusSecond(){
        long now = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long s=(cal.getTimeInMillis()-now)/1000;
        String se=String.valueOf(s);
        Integer second=Integer.valueOf(se);
        return second;
    }


    /**
     * @param args
     * @throws ParseException
     */
    public static void main(String[] args) throws ParseException {
//		System.out.println(formatDate(parseDate("2010/3/6")));
//		System.out.println(getDate("yyyy年MM月dd日 E"));
//		long time = new Date().getTime()-parseDate("2012-11-19").getTime();
//		System.out.println(time/(24*60*60*1000));
//        System.out.println(getTodayOverplusSecond());
    }

    /*
    * 将timestmp（1970年1月1日至今的毫秒数）转化为日期格式（yyyy-MM-dd）
    * */
    public static String getDateLong(String timestmp){
        return new SimpleDateFormat("yyyy-MM-dd").format(Long.parseLong(timestmp));
    }

    /**
     * @Author:zhenganke
     * @Description: 将时间根据当前时间比对,生成新的时间(例：几分钟前，几小时前)
     * @Date: 2018/8/13
     */
    public static String getLatelyTime(Date data, String pattern){
        /**
         * 判断和设置时间
         * 1天 = 24小时
         * 1周 = 24*7 = 168小时
         * 1月 = 24*30 = 720小时
         * */
        long latelyTime = new Date().getTime()-data.getTime();
        //得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm）
        String createTime = DateUtils.formatDate(data,pattern);
        /**这个是当前日期零点的时间*/
        String s = DateUtils.formatDate(new Date(),"yyyy-MM-dd");
        long nowTime = DateUtils.parseDate(s).getTime();
//        long nowTime = new Date(DateUtils.formatDate(new Date(),"yyyy-MM-dd")).getTime();
        /**这个是创建时间和零点时间的对比*/
        if(nowTime>data.getTime()){
            //如果没有过零点，就代表是昨天以及更前面
            nowTime = (nowTime-data.getTime()/(60*60*1000));
            //如果没有超过24小时，就代表是昨天
            if(nowTime<24){
                return "昨天";
            }else {
                return createTime;
            }
        }else {
            //如果过了零点，就代表是今天
            //先转化为分钟
            latelyTime = latelyTime/(60*1000);
            if(latelyTime<1){
                return "刚刚";
            }else if(latelyTime>=1 && latelyTime<60){
                return latelyTime+"分钟前";
            }else {
                //再转化为小时
                latelyTime = latelyTime/60;
                return latelyTime+"小时前";
            }
        }
    }

}
