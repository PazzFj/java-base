package com.pazz.java.core.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Peng Jian
 * @create: 2018/10/15 10:05
 * @description:
 */
public class DateFormatTest {

    public static void main(String[] args) throws Exception {

        String format = "yyyy-MM-dd HH:mm:ss";

        Date date = new Date();
        System.out.println("new Date() " + date);

        Calendar c1 = Calendar.getInstance();
        c1.setTime(date);
        c1.add(Calendar.SECOND, 60); //秒
        System.out.println(c1.getTime());

        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);
        c2.set(Calendar.SECOND, 0);//秒
        c2.set(Calendar.MINUTE, 0);//分
        c2.set(Calendar.HOUR_OF_DAY, 0);//时
        c2.add(Calendar.DAY_OF_MONTH, -7); //日
        System.out.println(c2.getTime());

        Calendar c3 = Calendar.getInstance();
        c3.setTime(date);
        c3.add(Calendar.MONTH, -1); //月
        c3.add(Calendar.YEAR, -1); //年
        System.out.println(c3.getTime());

        DateFormat dateFormat = new SimpleDateFormat(format);
        String str1 = dateFormat.format(c1.getTime());
        System.out.println(str1);
        String str2 = dateFormat.format(c2.getTime());
        System.out.println(str2);
        String str3 = dateFormat.format(c3.getTime());
        System.out.println(str3);

        System.out.println("**************************************************************");

        String str = "2018-12-11 23:20:00";
        Date d1 = new SimpleDateFormat(format).parse(str);
        System.out.println(d1);
        String d2 = new SimpleDateFormat(format).format(date);
        System.out.println(d2);
        System.out.println(d1.after(date)); //比较long大小
        System.out.println(d1.before(date));

    }

}
