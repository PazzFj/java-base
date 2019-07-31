package com.pazz.java.core.lambda;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Peng Jian
 * @date: 2018/7/4 13:53
 * @description: Stream API
 */
public class TestStreamAPI {

    //1. 创建 Stream
    public void test1() {
        //1. Collection 提供了两个方法  stream() 与 parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream(); //获取一个顺序流
        Stream<String> parallelStream = list.parallelStream(); //获取一个并行流

        //2. 通过 Arrays 中的 stream() 获取一个数组流
        Integer[] nums = new Integer[10];
        Stream<Integer> stream1 = Arrays.stream(nums);

        //3. 通过 Stream 类中静态方法 of()
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6);

        //4. 创建无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2).limit(10);
        stream3.forEach(System.out::println);

        //生成
        Stream<Double> stream4 = Stream.generate(Math::random).limit(2);
        stream4.forEach(System.out::println);
    }

    //2. 中间操作
    List<Employee> emps = Arrays.asList(
            new Employee(102, "李四", 59, 6666.66),
            new Employee(101, "张三", 18, 9999.99),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

	/*
	  筛选与切片
		filter——接收 Lambda ， 从流中排除某些元素。
		limit——截断流，使其元素不超过给定数量。
		skip(n) —— 跳过元素，返回一个扔掉了前 n 个元素的流。若流中元素不足 n 个，则返回一个空流。与 limit(n) 互补
		distinct——筛选，通过流所生成元素的 hashCode() 和 equals() 去除重复元素
	 */

    //内部迭代：迭代操作 Stream API 内部完成
    public void test2() {
        //所有的中间操作不会做任何的处理
        Stream<Employee> stream = emps.stream()
                .filter((e) -> {
                    System.out.println("测试中间操作");
                    return e.getAge() <= 35;
                });

        //只有当做终止操作时，所有的中间操作会一次性的全部执行，称为“惰性求值”
        stream.forEach(System.out::println);
    }

    //外部迭代
    public void test3() {
        Iterator<Employee> it = emps.iterator();

        while (it.hasNext()) {
            Employee employee = it.next();
            if(employee.getSalary() >= 5000){
                System.out.println(employee);
            }
        }
    }

    public void test4() {
        emps.stream()
                .filter((e) -> {
//                    System.out.println("短路！"); // &&  ||
                    return e.getSalary() >= 5000;
                }).limit(3)
                .forEach(System.out::println);
    }

    public void test5() {
        emps.parallelStream()
                .filter((e) -> e.getSalary() >= 5000)
                .skip(3)
                .forEach(System.out::println);
    }

    public void test6() {
        emps.stream()
                .distinct()
                .forEach(System.out::println);
    }

    public void test7(){
        List<String> strings = emps.stream().map(Employee::getName).collect(Collectors.toList());
        strings.forEach(System.out::println);
    }

    public static void main(String[] args) {
        TestStreamAPI streamAPI = new TestStreamAPI();

        streamAPI.test1();
//        streamAPI.test2();
//        System.out.println("**********test3*********");
//        streamAPI.test3();
//        System.out.println("**********test4*********");
//        streamAPI.test4();
//        System.out.println("**********test5*********");
//        streamAPI.test5();
//        System.out.println("**********test6*********");
//        streamAPI.test6();
//        streamAPI.test7();
    }

    @Data
    private static class Employee{
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

}
