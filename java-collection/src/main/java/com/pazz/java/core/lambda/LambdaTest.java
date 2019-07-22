package com.pazz.java.core.lambda;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: 彭坚
 * @create: 2018/12/12 15:12
 * @description:
 */
public class LambdaTest {

    public static void main(String[] args) {
        Integer integer1 = Integer.valueOf("1");
        Integer integer2 = Integer.valueOf("2");
        System.out.println(integer1 + integer2);
//        List<String> lists = Arrays.asList("admin", "admin1", "admin2", "pj");
//        //过滤条件
//        lists = lists.stream().filter(s -> s.startsWith("admin")).collect(Collectors.toList());
//        System.out.println(lists);
//        System.out.println("****************************************************************");
//        LambdaEntity le1 = new LambdaEntity("admin", "001");
//        LambdaEntity le2 = new LambdaEntity("zs", "002");
//        LambdaEntity le3 = new LambdaEntity("ls", "003");
//        LambdaEntity le4 = new LambdaEntity("ls", "004");
////        List<LambdaEntity> entityLists1 = Lists.newArrayList(le1, le2, le3, le4); //底层 Collections.addAll(list, elements);
//        List<LambdaEntity> entityLists = Arrays.asList(le1, le2, le3, le4);  //原生态
//        Map<String, List<LambdaEntity>> map = entityLists.stream().collect(Collectors.groupingBy(entity -> entity.getName(), Collectors.toList()));
//        System.out.println(map);
    }

    @Data
    private static class LambdaEntity {
        private String name;
        private String code;

        public LambdaEntity() {
        }

        public LambdaEntity(String name, String code) {
            this.name = name;
            this.code = code;
        }
    }

}
