package net.pazz.base.datatype;

import net.pazz.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author: Peng Jian
 * @date: 2018/6/5 11:25
 * @description: Long
 */
public class LongType {

    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, -7);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        System.out.println();

        System.out.println(DateUtils.convert(cal.getTime(), "yyyy-MM-dd HH:mm:ss"));
    }
}
