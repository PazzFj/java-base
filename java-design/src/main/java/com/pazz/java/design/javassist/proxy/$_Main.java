package com.pazz.java.design.javassist.proxy;

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
 * @description: Javassist 不仅可以生成类、变量和方法，还可以操作现有的方法，这在AOP上非常有用，比如做方法调用的埋点
 */
public class $_Main {

    public static void main(String[] args) throws Exception {
        /*
         Javassit使用方法
            Javassist是一个开源的分析、编辑和创建Java字节码的类库。它已加入了开放源代码JBoss 应用服务器项目,
            通过使用Javassist对字节码操作为JBoss实现动态AOP框架。javassist是jboss的一个子项目，其主要的优点，在于简单，而且快速。
            直接使用java编码的形式，而不需要了解虚拟机指令，就能动态改变类的结构，或者动态生成类。

            Javassist中最为重要的是ClassPool，CtClass ，CtMethod 以及 CtField这几个类。
            ClassPool：一个基于HashMap实现的CtClass对象容器，其中键是类名称，值是表示该类的CtClass对象。
                默认的ClassPool使用与底层JVM相同的类路径，因此在某些情况下，可能需要向ClassPool添加类路径或类字节。
            CtClass：表示一个类，这些CtClass对象可以从ClassPool获得。
            CtMethods：表示类中的方法。
            CtFields ：表示类中的字段。
         */
        ClassPool pool = ClassPool.getDefault();
        // ct 编译class类型
        CtClass ctClass = pool.makeClass("com.pazz.java.design.javassist.proxy.DefinitionImpl");
        // 给编译类型添加接口
        CtClass ctInterface = pool.makeInterface("com.pazz.java.design.javassist.proxy.InnerInterface");
        ctClass.addInterface(ctInterface);

        // ct 创建属性 id
        CtField ctField = new CtField(CtClass.intType, "id", ctClass);
        ctField.setModifiers(AccessFlag.PUBLIC);

        ctClass.addField(ctField);

        // 编译添加构造器
        CtConstructor constructor = CtNewConstructor.make("public DefinitionImpl(int id){this.id=id;}", ctClass);
        ctClass.addConstructor(constructor);

        // 编译添加实现方法
        CtMethod testM = CtNewMethod.make("public void testMethod(String des){System.out.println(\"make:\" + des);}", ctClass);
        testM.insertBefore("{System.out.println(\"之前插入代码\");}");
        testM.insertAfter("{System.out.println(\"之后插入代码\");}");
        ctClass.addMethod(testM);

        // 编译添加实现方法
        CtMethod helloM = CtNewMethod.make("public void helloM(){System.out.println(\"hello\" + this.id);}", ctClass);
        ctClass.addMethod(helloM);

        // 写入文件
        ctClass.writeFile();

        Class clazz = ctClass.toClass();

        InnerInterface point = (InnerInterface) clazz.getConstructor(int.class).newInstance(11);
        point.testMethod(" test ");
        point.helloM();
    }

}
