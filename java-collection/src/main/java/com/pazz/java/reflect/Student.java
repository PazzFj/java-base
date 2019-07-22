package com.pazz.java.reflect;

/**
 * @author: 彭坚
 * @create: 2019/4/22 10:51
 * @description:
 */
public class Student {

    private String name;
    private String cls;
    private int score;
    private String subject;

    public Student() {
    }

    public Student(String name, String cls, int score) {
        this.name = name;
        this.cls = cls;
        this.score = score;
    }

    public Student(String name, String cls, int score, String subject) {
        this.name = name;
        this.cls = cls;
        this.score = score;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
