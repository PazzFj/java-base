package net.pazz.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: 彭坚
 * @create: 2018/9/14 9:47
 * @description:
 */
public class LinkedTest {

    public static void main(String[] args) {
        LinkedList<String> linked = (LinkedList<String>) newLinked();
        linked.peek();  //取第一个的值
        linked.pop();   //从列表中删除并返回第一个元素。
        linked.push("first");
        linked.addLast("last");
        linked.addFirst("First");
        System.out.println(linked);
    }

    public static List<String> newLinked(){
        List<String> names = new LinkedList<>();
        names.add("ZhangSan");
        names.add("LiSi");
        names.add("WangWu");
        names.add("ZhaoLiu");
        names.add("MaQi");
        return names;
    }

}
