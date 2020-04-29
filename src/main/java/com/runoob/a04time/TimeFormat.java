package com.runoob.a04time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeFormat {

    private static String format = "yyyy-MM-dd HH:mm:ss";
    private static String format1 = "y/M-d H:m:s";
    private static String format2 =
                    "G       //年代标志符\n" +
                    "y       //年\n" +
                    "M       //月\n" +
                    "d       //日\n" +
                    "h       //时 在上午或下午 (1~12)\n" +
                    "H       //时 在一天中 (0~23)\n" +
                    "m       //分\n" +
                    "s       //秒\n" +
                    "S       //毫秒\n" +
                    "E       //星期\n" +
                    "D       //一年中的第几天\n" +
                    "F       //一月中第几个星期几\n" +
                    "w       //一年中第几个星期\n" +
                    "W       //一月中第几个星期\n" +
                    "a       //上午 / 下午 标记符\n" +
                    "k       //时 在一天中 (1~24)\n" +
                    "K       //时 在上午或下午 (0~11)\n" +
                    "z       //时区";


    public static void main(String[] args) {
        Date date = new Date();
        String strDateFormat = "y-M-d H:m:s";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(date));
        System.out.println();

        SimpleDateFormat sdf2 = new SimpleDateFormat();// 格式化时间
        sdf2.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
        Date date2 = new Date();// 获取当前时间
        System.out.println("现在时间：" + sdf2.format(date2)); // 输出已经格式化的现在时间（24小时制）


        Calendar cal = Calendar.getInstance();
//        int day = cal.get(Calendar.DATE);
//        int month = cal.get(Calendar.MONTH) + 1;
//        int year = cal.get(Calendar.YEAR);
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int dom = cal.get(Calendar.DAY_OF_MONTH);
        int doy = cal.get(Calendar.DAY_OF_YEAR);

        System.out.println("当期时间: " + cal.getTime());
//        System.out.println("日期: " + day);
//        System.out.println("月份: " + month);
//        System.out.println("年份: " + year);
        System.out.println("一周的第几天: " + (dow - 1));  // 星期日为一周的第一天输出为 1，星期一输出为 2，以此类推
        System.out.println("一月中的第几天: " + dom);
        System.out.println("一年的第几天: " + doy);
        System.out.println();

        SimpleDateFormat sdf3 = new SimpleDateFormat(format2);// 格式化时间

        System.out.println(sdf3.format(new Date()));

    }
}
/**
 *   SimpleDateFormat函数语法：
 *  
 *   G 年代标志符
 *   y 年
 *   M 月
 *   d 日
 *   h 时 在上午或下午 (1~12)
 *   H 时 在一天中 (0~23)
 *   m 分
 *   s 秒
 *   S 毫秒
 *   E 星期
 *   D 一年中的第几天
 *   F 一月中第几个星期几
 *   w 一年中第几个星期
 *   W 一月中第几个星期
 *   a 上午 / 下午 标记符
 *   k 时 在一天中 (1~24)
 *   K 时 在上午或下午 (0~11)
 *   z 时区
 *  
 */
