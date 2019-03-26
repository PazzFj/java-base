package net.pazz.base;

import net.pazz.base.generics.Generics;
import net.pazz.base.generics.Parent;

/**
 * @author: Peng Jian
 * @date: 2018/6/4 11:35
 * @description: 泛型l
 */
public class GenericMain {

    public static void main(String[] args) {
        Generics<Parent> generics = new Generics<Parent>();
        Parent exampleAddress = (Parent) generics.testMethod4(generics);
        System.out.println(exampleAddress.getName());
    }

}
