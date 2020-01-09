package com.pazz.java.design.responsibility;

/**
 * @author: Peng Jian
 * @create: 2020/1/9 16:33
 * @description: 错误日志
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }

}
