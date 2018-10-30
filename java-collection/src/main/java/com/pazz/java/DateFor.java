package com.pazz.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: Peng Jian
 * @create: 2018/10/15 10:05
 * @description:
 */
public class DateFor {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND, 1); //秒
        System.out.println(cal.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(new Date());
        cal2.set(Calendar.SECOND, 0);//秒
        cal2.set(Calendar.MINUTE, 0);//分
        cal2.set(Calendar.HOUR_OF_DAY, 0);//时
        cal2.add(Calendar.DAY_OF_MONTH, -7); //天
        System.out.println(cal2.getTime());

        Calendar cal3 = Calendar.getInstance();
        cal3.setTime(new Date());
        cal3.add(Calendar.DAY_OF_MONTH, -1);
        cal3.set(Calendar.SECOND, 0);
        cal3.set(Calendar.MINUTE, 0);
        cal3.set(Calendar.HOUR_OF_DAY, 0);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str1 = dateFormat.format(cal.getTime());
        System.out.println(str1);
        String str2 = dateFormat.format(cal2.getTime());
        System.out.println(str2);
        String str3 = dateFormat.format(cal3.getTime());
        System.out.println(str3);

        if(true){
            System.out.println("a");
        }else if(true){
            System.out.println("b");
        }

    }

}
