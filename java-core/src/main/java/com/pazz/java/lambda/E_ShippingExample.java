package com.pazz.java.lambda;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Auther peng jian
 * @Date 2020/1/2 9:10
 */
public class E_ShippingExample {

    public static void main(String[] args) {
        /**
         * a.先按照提单号分组，再判断箱型是否一致，然后判断指定车队是否一致
         * b.不同提单号的箱子，肯定归属于不同的订单
         * c.相同提单号、不同箱型，需按照箱型区分成不同的订单
         * d.相同提单号、相同箱型、不同指定车队，须按照指定车队区分成不同的订单
         * e.相同提单号、相同箱型、相同指定车队，捆绑在一个订单之内
         */
        List<Model> models = testData();
        models = conversion(models);
        models.forEach(System.out::println);
    }


    public static List<Model> conversion(List<Model> models) {
        List<Model> modelList = groupA(models);
        return modelList;
    }

    public static List<Model> groupA(List<Model> models) {
        List<Model> resultLists = new ArrayList<>();
        Map<String, List<Model>> attAMaps = models.stream().collect(Collectors.groupingBy(model -> model.getAttA(), Collectors.toList()));
        attAMaps.forEach((k, v) -> {
            if (v.size() == 1) {
                Model m = v.get(0);
                m.setCount(1);
                resultLists.add(m);
            } else {
                resultLists.addAll(groupB(v));
            }
        });
        return resultLists;
    }

    public static List<Model> groupB(List<Model> models) {
        List<Model> resultLists = new ArrayList<>();
        Map<String, List<Model>> attBMaps = models.stream().collect(Collectors.groupingBy(model -> model.getAttB(), Collectors.toList()));
        attBMaps.forEach((k, v) -> {
            if (v.size() == 1) {
                Model m = v.get(0);
                m.setCount(1);
                resultLists.add(m);
            } else {
                resultLists.addAll(groupC(v));
            }
        });
        return resultLists;
    }

    public static List<Model> groupC(List<Model> models) {
        List<Model> resultLists = new ArrayList<>();
        Map<String, List<Model>> attCMaps = models.stream().collect(Collectors.groupingBy(model -> model.getAttC(), Collectors.toList()));
        attCMaps.forEach((k, v) -> {
            if (v.size() == 1) {
                Model m = v.get(0);
                m.setCount(1);
                resultLists.add(m);
            } else {
                Model m = v.get(0);
                m.setCount(v.size());
                resultLists.add(m);
            }
        });
        return resultLists;
    }

    @Data
    public static class Model {
        private String attA;
        private String attB;
        private String attC;
        private int count;

        public Model(String attA, String attB, String attC, int count) {
            this.attA = attA;
            this.attB = attB;
            this.attC = attC;
            this.count = count;
        }
    }

    public static List<Model> testData() {
        List<Model> models = new ArrayList<>();
        models.add(new Model("att1", "att1", "att2", 0));
        models.add(new Model("att1", "att2", "att3", 0));
        models.add(new Model("att1", "att2", "att3", 0));
        models.add(new Model("att1", "att3", "att3", 0));
        models.add(new Model("att1", "att3", "att3", 0));
        models.add(new Model("att2", "att2", "att3", 0));
        models.add(new Model("att2", "att2", "att3", 0));
        models.add(new Model("att2", "att2", "att3", 0));
        models.add(new Model("att3", "att3", "att3", 0));
        return models;
    }
    /*
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

     */

}
