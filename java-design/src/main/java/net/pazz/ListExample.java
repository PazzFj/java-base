package net.pazz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 彭坚
 * @create: 2018/12/11 13:54
 * @description:
 */
public class ListExample {

    public static void main(String[] args) {
        List<Test> tests = new ArrayList<>();
        tests.add(new Test("admin", "01"));
        tests.add(new Test("zhangsan", "02"));
        tests.add(new Test("lisi", "03"));
        tests.add(new Test("lisi", "03"));

        tests = tests.stream().filter(t -> t.getName().equals("lisi")).collect(Collectors.toList());
        System.out.println(tests);
    }


    static class Test{
        private String name;
        private String code;

        public Test() {
        }

        public Test(String name, String code) {
            this.name = name;
            this.code = code;
        }

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    ", code='" + code + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }

}
