package com.pazz.java.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommonUtil {

    public interface GroupBy<T> {
        T groupBy(Object obj);
    }

    public static final <T extends Comparable<T>, D> Map<T, List<D>> group(Collection<D> collection, GroupBy<T> group) {
        if (collection == null || collection.isEmpty()) {
            System.out.println("分組集合不能為空!");
            return null;
        }
        if (group == null) {
            System.out.println("分組依據接口不能為Null!");
            return null;
        }

        // 迭代集合
        Iterator<D> iter = collection.iterator();
        Map<T, List<D>> map = new HashMap<>();
        while (iter.hasNext()) {
            D d = iter.next(); // 集合中的对象
            T t = group.groupBy(d); // 根据对象
            if (map.containsKey(t)) {
                map.get(t).add(d);
            } else {
                List<D> list = new ArrayList<>();
                list.add(d);
                map.put(t, list);
            }
        }
        return map;
    }


    public static <K, V> void listGroup2Map(List<V> list, Map<K, List<V>> map, Class<V> clazz, String methodName) {
        // 入参非法行校验
        if (null == list || null == map || null == clazz) {
            System.out.print("CommonUtil.listGroup2Map 入参错误，list：" + list + " ；map：" + map + " ；clazzs：" + clazz + " ；methodName：" + methodName);
            return;
        }

        // 获取方法
        Method method = getMethodByName(clazz, methodName);
        // 非空判断
        if (null == method) {
            return;
        }

        // 正式分组
        listGroup2Map(list, map, method);
    }

    public static Method getMethodByName(Class<?> clazz, String methodName) {
        Method method = null;
        // 入参不能为空
        if (null == clazz) {
            System.out.print("CommonUtil.getMethodByName 入参错误，clazzs：" + clazz + " ；methodName：" + methodName);
            return method;
        }

        try {
            method = clazz.getDeclaredMethod(methodName); // 根据方法名称 返回Method对象
        } catch (Exception e) {
            System.out.print("类获取方法失败！");
        }

        return method;
    }

    public static <K, V> void listGroup2Map(List<V> list, Map<K, List<V>> map, Method method) {
        // 入参非法行校验
        if (null == list || null == map || null == method) {
            System.out.print("CommonUtil.listGroup2Map 入参错误，list：" + list + " ；map：" + map + " ；method：" + method);
            return;
        }
        try {
            // 开始分组
            Object key;
            List<V> listTmp;
            for (V val : list) { // 遍历很多条数据
                key = method.invoke(val); // 把对象的content字段  比作key
                listTmp = map.get(key);  // 根据key 去map去中查找
                if (null == listTmp) {
                    listTmp = new ArrayList<V>(); // 为null 就 put
                    map.put((K) key, listTmp);
                }
                listTmp.add(val);
            }
        } catch (Exception e) {
            System.out.print("分组失败！");
        }
    }

}
