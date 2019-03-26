package net.pazz.design.template;

/**
 * @author: Peng Jian
 * @date: 2018/8/13 14:35
 * @description:
 */
public class ConcreteTemplate extends AbstractTemplate {

    //重写父类的方法
//    @Override
//    public void hookMethod(){
//        System.out.println("ConcreteTemplate#hookMethod()");
//    }

    //基本方法的实现
    @Override
    public void abstractMethod() {
        //业务相关的代码
        System.out.println("ConcreteTemplate#abstractMethod()");
    }

//    @Override
//    public void concreteMethod() {
//        System.out.println("ConcreteTemplate#concreteMethod()");
//    }

}
