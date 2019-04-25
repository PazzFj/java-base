package com.pazz.java.proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.bytecode.AccessFlag;

/**
 * @author: 彭坚
 * @create: 2019/4/22 9:34
 * @description: Javassist不仅可以生成类、变量和方法，还可以操作现有的方法，这在AOP上非常有用，比如做方法调用的埋点
 */
public class AppJavassist {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ct = pool.makeClass("com.pazz.java.proxy.Point");
        ct.setInterfaces(new CtClass[]{pool.makeInterface("com.pazz.java.proxy.HelloInter")});

        CtField x = new CtField(CtClass.intType, "id", ct);

        x.setModifiers(AccessFlag.PUBLIC);

        ct.addField(x);

        CtConstructor constructor = CtNewConstructor.make("public Point(int pId){this.id=pId;}", ct);
        ct.addConstructor(constructor);

        CtMethod helloM = CtNewMethod.make("public void hello(String des){ System.out.println(des);}", ct);
        ct.addMethod(helloM);

        ct.writeFile();

        Class clazz = ct.toClass();

        Class intCls = int.class;
        System.out.println(intCls.getName());

        HelloInter point = (HelloInter)clazz.getDeclaredConstructor(int.class).newInstance(11);
        point.hello("me name");
    }

}
