package net.pazz.base.stream;

import lombok.Data;

/**
 * @author: Peng Jian
 * @date: 2018/7/4 13:57
 * @description:
 */
@Data
public class Employee {

    private int id;
    private String name;
    private int age;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
