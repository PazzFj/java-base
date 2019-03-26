package net.pazz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 彭坚
 * @create: 2018/12/11 10:02
 * @description:
 */
public class DateExample {

    public static void main(String[] args) throws Exception {
        Date curTime = new Date();
        String oldTime = "2017-12-11 10:10:33";
        String format = "yyyy-MM-dd HH:mm:ss";
        Date old = new SimpleDateFormat(format).parse(oldTime);
//        String cur =  new SimpleDateFormat(format).format(curTime);
        System.out.println("当前时间before以前时间: " + curTime.before(old));
    }

}
