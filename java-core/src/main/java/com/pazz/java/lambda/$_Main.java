package com.pazz.java.lambda;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther peng jian
 * @Date 2019/12/31 16:57
 */
public class $_Main {

    public static void main(String[] args) {
        // filter(true)---limit(1)---skip(n)跳过某条---distinct去重
        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personList.add(new Person(i % 2 == 0 ? 1 : 2, i % 2 != 0 ? "p1" : "p2", i * 3));
        }

        Map<String, List<Person>> idMaps = personList.stream().collect(Collectors.groupingBy(Person::getName));
        System.out.println("某字段分组: " + idMaps.size());

        int count = personList.stream().mapToInt(Person::getAge).sum();
        System.out.println("某字段求和: " + count);

        Optional<Person> max = personList.stream().max(Comparator.comparing(Person::getAge));
        Optional<Person> min = personList.stream().min(Comparator.comparing(Person::getAge));
        System.out.println("某字段最大值: " + max);
        System.out.println("某字段最小值: " + min);

        List<Person> filter = personList.stream().filter(p -> p.getName().equals("p1")).limit(1).collect(Collectors.toList());
        System.out.println("false 过滤: " + filter.get(0).getName() + " limit: " + filter.size());
    }

    @Data
    public static class Person {
        private int id;
        private String name;
        private int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }

}
