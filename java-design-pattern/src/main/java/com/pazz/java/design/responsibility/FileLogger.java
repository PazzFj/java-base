package com.pazz.java.design.responsibility;

/**
 * @author: Peng Jian
 * @create: 2020/1/9 16:34
 * @description: 文件日志
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }

}
