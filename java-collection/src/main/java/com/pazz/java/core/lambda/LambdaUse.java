package com.pazz.java.core.lambda;

import com.pazz.java.util.CommonUtil;
import lombok.Data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: 彭坚
 * @create: 2019/5/8 15:44
 * @description:
 */
public class LambdaUse {

    public static void main(String[] args) throws Exception {
        List<Property> properties = newLists();

        List<Property> propertyList = properties.stream().map(p -> cast(p)).collect(Collectors.toList());
        propertyList.stream().peek(p -> System.out.print(p));       // peek 遍历


        Map<String, List<Property>> valueMaps = properties.stream().collect(Collectors.groupingBy(Property::getVal));     //根据某个字段分组
        System.out.println("group: " + valueMaps);

        int counts = properties.stream().mapToInt(Property::getCount).sum();        //获取集合某个字段和(int类型)
        System.out.println("sum: " + counts);

        Optional<Property> max = properties.stream().max(Comparator.comparing(Property::getTime));  // 获取时间最大的对象
        System.out.println("max: " + max);

        Optional<Property> min = properties.stream().min(Comparator.comparing(Property::getTime));  // 获取时间最小的对象
        System.out.println("min: " + min);

        List<Property> filter = properties.stream().filter(p -> p.val.equals("v")).collect(Collectors.toList());  // 过滤(true)
        System.out.println("filter: " + filter);

        // 分组查询数量
        List<Entity> dataList = newEntityData();
        Map<String, List<Entity>> listMap = dataList.stream().collect(Collectors.groupingBy(obj -> obj.getAttributeA(), Collectors.toList()));
        List<Entity> mergeList = merge(listMap);
        mergeList.forEach(System.out::println);


        /**
         * a.先按照提单号分组，再判断箱型是否一致，然后判断指定车队是否一致
         * b.不同提单号的箱子，肯定归属于不同的订单
         * c.相同提单号、不同箱型，需按照箱型区分成不同的订单
         * d.相同提单号、相同箱型、不同指定车队，须按照指定车队区分成不同的订单
         * e.相同提单号、相同箱型、相同指定车队，捆绑在一个订单之内
         */
        //方案一
        List<Entity> entities = newEntityData();
        List<Entity> entityList = new ArrayList<>();
        conversion(entities, entityList);
        entityList.forEach(System.out::println);

        //方案二
        List<Builder> list = newBuilderData();
        // 进行分组 1
        Map<String, List<Builder>> map2 = new LinkedHashMap<>();
        CommonUtil.listGroup2Map(list, map2, Builder.class, "getContent");// 输入方法名

        // 分组二
        Map<String, List<Builder>> map = CommonUtil.group(list, new CommonUtil.GroupBy<String>() {
            @Override
            public String groupBy(Object obj) {
                LambdaUse.Builder d = (LambdaUse.Builder) obj;
                return d.getContent(); // 分组依据为课程ID
            }
        });

        map.forEach((k, v) -> {
            System.out.println("key1: " + k + "  value: " +v.size());
        });

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

        public Property(Date time, String val, int count) {
            this.time = time;
            this.val = val;
            this.count = count;
        }

    }


    @Data
    private static class Builder{
        private Long id;
        private Long courseId;
        private String content;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setCourseId(Long courseId) {
            this.courseId = courseId;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }
    }

    @Data
    private static class Entity {
        private int id;
        private String attributeA;
        private String attributeB;
        private String attributeC;
        private int count;

        private List<Entity> entities = new ArrayList<>();

        public Entity() {
        }

        public Entity(int id, String attributeA, String attributeB, String attributeC, int count) {
            this.id = id;
            this.attributeA = attributeA;
            this.attributeB = attributeB;
            this.attributeC = attributeC;
            this.count = count;
        }
    }


    private static List<Entity> merge(Map<String, List<Entity>> listMap) {
        List<Entity> entities = new ArrayList<>();
        listMap.forEach((k, v) -> {
            if (v.size() == 1) {
                entities.addAll(v); //无key1重复的 先保存
            } else {
                // 有重复的数据 在做分解
                entities.addAll(repetitionMerge(v, null));
            }
        });
        return entities;
    }

    // 此次进来的数据 key1 都是相等的。
    private static List<Entity> repetitionMerge(List<Entity> entities, String str) {
        List<Entity> arrayList = new ArrayList<>();
        Map<String, List<Entity>> key2Map = entities.stream().collect(Collectors.groupingBy(obj -> obj.getAttributeB(), Collectors.toList()));
        key2Map.forEach((k, v) -> {
            if (v.size() == 1) { // 这一步骤是key1 下面  key2无重复的 保存
                arrayList.addAll(v);
            } else {
                // 证明 key2 有重复的
                arrayList.addAll(repetition2Merge(v));
            }
        });
        return arrayList;
    }

    // 这里数据证明 key2 都是相同的了
    private static List<Entity> repetition2Merge(List<Entity> entities) {
        List<Entity> arrayList = new ArrayList<>();
        Map<String, List<Entity>> key2Map = entities.stream().collect(Collectors.groupingBy(obj -> obj.getAttributeC(), Collectors.toList()));
        key2Map.forEach((k, v) -> {
            if (v.size() == 1) { // 代表key3 无重复的 就保存
                arrayList.addAll(v);
            } else {    // 有key3 重复 记录数量在保存一条
                Entity e = v.get(0);
                arrayList.add(new Entity(e.getId(), e.getAttributeA(), e.getAttributeB(), e.getAttributeC(), v.size()));
            }
        });
        return arrayList;
    }


    // 测试一、
    private static void conversion(List<Entity> entityList, List<Entity> newList) {
        newList.addAll(groupAttributeA(entityList));
    }

    // 分组key1
    private static List<Entity> groupAttributeA(List<Entity> entityList) {
        List<Entity> entities = new ArrayList<>();
        Map<String, List<Entity>> map = entityList.stream().collect(Collectors.groupingBy(entity -> entity.getAttributeA(), Collectors.toList()));
        map.forEach((k, v) -> {
            if (v.size() == 1) {
                // 属性1 没有重复就保存
                Entity entity = v.get(0);
                entity.setCount(1);
                entities.add(entity);
            } else {
                // 有重复值存在, 继续解析
                entities.addAll(groupAttributeB(v));
            }
        });
        return entities;
    }

    //分组key2
    public static List<Entity> groupAttributeB(List<Entity> entityList) {
        // entityList 进来的数据 一定是key1相同的
        List<Entity> entities = new ArrayList<>();
        Map<String, List<Entity>> map = entityList.stream().collect(Collectors.groupingBy(entity -> entity.getAttributeB(), Collectors.toList()));
        map.forEach((k, v) -> {
            if (v.size() == 1) {  // 无key2重复
                Entity entity = v.get(0);
                entity.setCount(1);
                entities.add(entity);
            } else {
                entities.addAll(groupAttributeC(v));
            }
        });

        return entities;
    }

    //分组key3
    public static List<Entity> groupAttributeC(List<Entity> entityList) {
        List<Entity> entities = new ArrayList<>();
        Map<String, List<Entity>> map = entityList.stream().collect(Collectors.groupingBy(entity -> entity.getAttributeC(), Collectors.toList()));
        map.forEach((k, v) -> {
            if (v.size() == 1) { //无key3 重复
                Entity entity = v.get(0);
                entity.setCount(1);
                entities.add(entity);
            }else{
                Entity entity = new Entity();
                entity.setCount(v.size());
                entity.setId(v.get(0).getId());
                entity.setAttributeA(v.get(0).getAttributeA());
                entity.setAttributeB(v.get(0).getAttributeB());
                entity.setAttributeC(v.get(0).getAttributeC());
                entities.add(entity);
            }
        });
        return entities;
    }

    // 实例化一个集合
    public static List<Entity> newEntityData() {
        List<Entity> entities = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            entities.add(new Entity(i, "提单号" + i, "箱型" + i, "车队" + i, 0));
        }
        entities.add(new Entity(6, "提单号" + 1, "箱型" + 1, "车队" + 1, 0));
        entities.add(new Entity(7, "提单号" + 1, "箱型" + 2, "车队" + 1, 0));
        entities.add(new Entity(8, "提单号" + 1, "箱型" + 2, "车队" + 1, 0));
        entities.add(new Entity(9, "提单号" + 2, "箱型" + 2, "车队" + 2, 0));
        return entities;
    }

    //实例化一个集合
    public static List<Builder> newBuilderData(){
        final int loop = 1000;
        List<Builder> list = new ArrayList<Builder>(); // size=8 * loop
        for (int i = 0; i < loop; i++) {
            list.add(new Builder().setId(1L).setCourseId(200010L).setContent("AAA"));
            list.add(new Builder().setId(2L).setCourseId(200010L).setContent("BBB"));
            list.add(new Builder().setId(3L).setCourseId(200011L).setContent("CCC"));
            list.add(new Builder().setId(4L).setCourseId(200011L).setContent("DDD"));
            list.add(new Builder().setId(5L).setCourseId(200010L).setContent("EEE"));
            list.add(new Builder().setId(6L).setCourseId(200011L).setContent("FFF"));
            list.add(new Builder().setId(7L).setCourseId(200010L).setContent("AAA"));
            list.add(new Builder().setId(8L).setCourseId(200012L).setContent("HHH"));
        }
        return list;
    }

}
