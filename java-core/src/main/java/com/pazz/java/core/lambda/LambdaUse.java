package com.pazz.java.core.lambda;

import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: 彭坚
 * @create: 2019/5/8 15:44
 * @description:
 */
public class LambdaUse {

    public static void main(String[] args) throws Exception {
        List<Property> properties = newLists();

        Optional<Property> max = properties.stream().max(Comparator.comparing(Property::getTime));  // 获取时间最大的对象
        Optional<Property> min = properties.stream().min(Comparator.comparing(Property::getTime));  // 获取时间最小的对象
        int counts = properties.stream().mapToInt(Property::getCount).sum();        //获取集合某个字段和(int类型)
        Map<String, List<Property>> listMap = properties.stream().collect(Collectors.groupingBy(Property::getVal));     //根据某个字段分组
        List<Property> filter = properties.stream().filter(p -> p.val.equals("v")).collect(Collectors.toList());  // 过滤(true)

        System.out.println("group: " + listMap);
        System.out.println("sum: " + counts);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("filter: " + filter);
        properties.stream().peek(p -> System.out.print(p));       // peek 遍历
    }

    public static List<Property> newLists() {
        List<Property> properties = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                properties.add(new Property(new Date(), "v" + i, i * 2));
            } else {
                properties.add(new Property(new Date(), "v", i * 3));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    private static Property cast(Property property) {
        property.setCount(10);
        property.setVal("update");
        property.setTime(null);
        return property;
    }

    @Data
    private static class Property {
        private final static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        private Date time;  //日期
        private String val;
        private int count;

        public Property() {
        }

        public Property(Date time, String val, int count) {
            this.time = time;
            this.val = val;
            this.count = count;
        }

        @Override
        public String toString() {
            return "P{" +
                    "time=" + time +
                    ", val='" + val + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

}
