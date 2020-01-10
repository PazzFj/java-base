package com.pazz.java.design.responsibility;

/**
 * @author: Peng Jian
 * @create: 2020/1/9 16:32
 * @description: 控制台日志
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }

}
