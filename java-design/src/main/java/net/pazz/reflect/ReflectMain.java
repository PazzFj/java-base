package net.pazz.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author: 彭坚
 * @create: 2018/9/10 16:02
 * @description:
 */
public class ReflectMain {

    public static void main(String[] args) throws Exception {
        ReflectEntity entity = new ReflectEntity("test");
        Class aClass = entity.getClass();
        Constructor[] constructors = aClass.getDeclaredConstructors();
        Field[] fields = aClass.getDeclaredFields();
        Method[] methods = aClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print(methods[i].getName() + "  ");
        }
        System.out.println();
        for (int i = 0; i < constructors.length; i++) {
            System.out.print(constructors[i].getAnnotatedReturnType().getType() + "  ");
        }
        System.out.println();
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i].getName() + "  " );
        }
        System.out.println();
        Method method = aClass.getMethod("getName");
        System.out.println(method.invoke(entity));
    }

}
