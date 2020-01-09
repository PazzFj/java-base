package com.pazz.java.netty;

import java.util.Date;

/**
 * @author: 彭坚
 * @create: 2019/1/16 9:38
 * @description:
 */
public class Time {

    private final long value;

    public Time() {
        this(System.currentTimeMillis() / 1000L);
    }

    public Time(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        return new Date((value()) * 1000L).toString();
    }
}
