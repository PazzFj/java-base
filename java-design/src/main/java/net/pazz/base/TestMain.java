package net.pazz.base;

import net.pazz.base.group.entity.Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMain {

    public static void main(String[] args) {
        List<Entity> dataList = newEntityData();
        Map<String, List<Entity>> listMap = dataList.stream().collect(Collectors.groupingBy(obj -> obj.getAttributeA(), Collectors.toList()));
        List<Entity> mergeList = merge(listMap);
        mergeList.forEach(System.out::println);
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

    private static List<Entity> newEntityData() {
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity(1, "A" + 1, "B" + 1, "C" + 1, 1));
        entities.add(new Entity(2, "A" + 2, "B" + 2, "C" + 2, 1));
        entities.add(new Entity(3, "A" + 3, "B" + 3, "C" + 3, 1));
        entities.add(new Entity(4, "A" + 4, "B" + 4, "C" + 4, 1));
        entities.add(new Entity(5, "A" + 3, "B" + 5, "C" + 5, 1));
        entities.add(new Entity(6, "A" + 6, "B" + 6, "C" + 6, 1));
        entities.add(new Entity(7, "A" + 7, "B" + 7, "C" + 7, 1));
        entities.add(new Entity(8, "A" + 8, "B" + 8, "C" + 8, 1));
        entities.add(new Entity(9, "A" + 1, "B" + 2, "C" + 1, 1));
        entities.add(new Entity(10, "A" + 1, "B" + 1, "C" + 2, 1));
        entities.add(new Entity(11, "A" + 1, "B" + 1, "C" + 2, 1));
        entities.add(new Entity(12, "A" + 1, "B" + 2, "C" + 2, 1));
        entities.add(new Entity(13, "A" + 1, "B" + 2, "C" + 1, 1));
        return entities;
    }


}
