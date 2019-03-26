package net.pazz.base.group;

import net.pazz.base.group.entity.Builder;
import net.pazz.base.group.entity.Entity;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Peng Jian
 * @date: 2018/6/6 14:10
 * @description:
 */
public class TestMain {


    public static void main(String[] args) {
        /**
         * a.先按照提单号分组，再判断箱型是否一致，然后判断指定车队是否一致
         * b.不同提单号的箱子，肯定归属于不同的订单
         * c.相同提单号、不同箱型，需按照箱型区分成不同的订单
         * d.相同提单号、相同箱型、不同指定车队，须按照指定车队区分成不同的订单
         * e.相同提单号、相同箱型、相同指定车队，捆绑在一个订单之内
         */
        //方案一
//        List<Entity> entities = newEntityData();
//        List<Entity> entityList = new ArrayList<>();
//        conversion(entities, entityList);
//        entityList.forEach(System.out::println);

        //方案二
        List<Builder> list = newBuilderData();
        // 进行分组 1
        Map<String, List<Builder>> map2 = new LinkedHashMap<>();
        CommonUtils.listGroup2Map(list, map2, Builder.class, "getContent");// 输入方法名

        // 分组二
        Map<String, List<Builder>> map = CommonUtils.group(list, new CommonUtils.GroupBy<String>() {
            @Override
            public String groupBy(Object obj) {
                Builder d = (Builder) obj;
                return d.getContent(); // 分组依据为课程ID
            }
        });

        map.forEach((k, v) -> {
            System.out.println("key1: " + k + "  value: " +v.size());
        });
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
