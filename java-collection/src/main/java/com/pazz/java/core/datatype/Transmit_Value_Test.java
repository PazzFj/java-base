package com.pazz.java.core.datatype;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Peng Jian
 * @create: 2018/10/30 9:36
 * @description: 值传递与对象传递
 */
public class Transmit_Value_Test {

    public static void main(String[] args) {

        System.out.println("*******************值传递**************************");
        String s1 = "原值1";
        String s2 = s1;
        s1 = "原值2";
        System.out.println("基本类型被修改后, 原值value是否修改：是 " + s1);
        System.out.println("基本类型被修改后, 原值value是否修改：否 " + s2);
        System.out.println();

        System.out.println("********************对象引用传递********************");
        QuoteVal v1 = new QuoteVal("原值1");
        QuoteVal v2 = v1;
        v2.setName("原值2");
//        v1 = null;
        System.out.println("引用对象被修改后, 原值hashCode是否修改：否 " + v1);
        System.out.println("引用对象被修改后, 原值hashCode是否修改：否 " + v2);
        System.out.println();

        System.out.println("*********************数组引用传递*******************");
        List<String> acid1 = newACID();
        List<String> acid2 = acid1;
        acid1.add("新增DD");
        acid2.add("修改UU");
        System.out.println("引用数组被修改后, 原值value是否修改：是 " + acid1);
        System.out.println("引用数组被修改后, 原值value是否修改：是 " + acid2);
        System.out.println();

        System.out.println("**********************map引用list对象***************");
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put("原值", list);
        list.add("修改");
        System.out.println("引用list被修改后, map中是否修改：是 " + map.get("原值"));
        System.out.println();
    }

    public static List newACID(){
        List<String> names = new ArrayList<>();
        names.add("A原子性");
        names.add("C一致性");
        names.add("I隔离性");
        names.add("D持久性");
        return names;
    }

    @Data
    static class QuoteVal {
        String name;

        public QuoteVal(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return " {哈希值: " + hashCode() + "  name: " + this.name + "}";
        }
    }

}
