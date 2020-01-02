package com.pazz.java.time;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        test();
        Date currentDate = new Date();
        String format = "yyyy-MM-dd HH:mm:ss";
        DateFormat dateFormat = new SimpleDateFormat(format);
        String d2 = dateFormat.format(currentDate);
        System.out.println("current 时间： " + d2);

        Calendar c1 = Calendar.getInstance();
        c1.setTime(currentDate);
        c1.add(Calendar.SECOND, 60); //秒
        c1.add(Calendar.MINUTE, 60); //分
        c1.add(Calendar.HOUR_OF_DAY, 1);  //时
        c1.add(Calendar.DAY_OF_MONTH, 1); //日
        c1.add(Calendar.MONTH, 1); //月
        c1.add(Calendar.YEAR, 10); //年
        System.out.println("update 时间： " + dateFormat.format(c1.getTime()));
        System.out.println("**************************************************************");

        String str = "2020-12-12 23:20:00";
        Date strDate = dateFormat.parse(str);

        // 时间比较大小  这个时间 在 后面时间 之前? befor
        System.out.println(dateFormat.format(c1.getTime()) + " 在 " + "2020-12-12 23:20:00 之前 " + c1.getTime().before(strDate));

    }

    public static void test() {
        LocalDateTime dateTime = LocalDateTime.now();
        // 2020-01-02T11:44:27.155
        System.out.println(dateTime);
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

}
