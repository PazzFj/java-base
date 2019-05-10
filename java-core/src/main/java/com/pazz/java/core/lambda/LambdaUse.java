package com.pazz.java.core.lambda;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author: 彭坚
 * @create: 2019/5/8 15:44
 * @description:
 */
public class LambdaUse {

    public static void main(String[] args) throws Exception {


        List<Property> properties = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                properties.add(new Property(new Date(), true, "v" + i, i));
            }else{
                properties.add(new Property(new Date(), false, "v", i));
            }
            Thread.sleep(1000);
        }

        properties.stream().forEach(property -> {
            System.out.println(property);
        });

        Optional<Property> max = properties.stream().max(Comparator.comparing(Property::getTime));  // 获取时间最大的对象
        Optional<Property> min = properties.stream().min(Comparator.comparing(Property::getTime));  // 获取时间最小的对象
        System.out.println();

        System.out.println(max);
        System.out.println(min);

        List<Property> filters1 = properties.stream().filter(Property::isFilter).collect(Collectors.toList());          // 过滤为true的数据
        List<Property> filters2 = properties.stream().filter(p -> p.getVal().equals("v")).collect(Collectors.toList()); // 过滤为true的数据
        System.out.println(filters1);
        System.out.println(filters2);

        List<Property> filters3 = properties.stream().map(p -> cast(p)).peek(p -> System.out.println(p.getVal())).collect(Collectors.toList());       // map
        System.out.println(filters3);
    }

    private static Property cast(Property property){
        property.setIndex(2);
        return property;
    }

    private static class Property {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private Date time;
        private boolean filter;
        private String val;
        private int index;

        public Property() {
        }

        public Property(Date time, boolean filter, String val, int index) {
            this.time = time;
            this.filter = filter;
            this.val = val;
            this.index = index;
        }

        public Date getTime() {
            return time;
        }

        public void setTime(Date time) {
            this.time = time;
        }

        public boolean isFilter() {
            return filter;
        }

        public void setFilter(boolean filter) {
            this.filter = filter;
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Property{" +
                    "time=" + format.format(time) +
                    ", filter=" + filter +
                    ", val='" + val + '\'' +
                    ", index=" + index +
                    '}';
        }
    }

}
