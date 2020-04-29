package com.runoob.a04time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTime {

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

/*        Calendar cal = Calendar.getInstance();
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


        */
        SimpleDateFormat sdf3 = new SimpleDateFormat(format2);// 格式化时间
        System.out.println(sdf3.format(Calendar.getInstance().getTime()));

    }
}