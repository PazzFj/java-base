package com.pazz.java.design;

import com.pazz.java.design.factory.AbstractFactory;
import com.pazz.java.design.factory.Color;
import com.pazz.java.design.factory.FactoryProdive;
import com.pazz.java.design.factory2.DefaultPersonCreatorFactory;
import com.pazz.java.design.factory2.Person;
import com.pazz.java.design.factory2.PersonCreatorFactory;
import org.junit.Test;

/**
 * @author: 彭坚
 * @create: 2019/2/28 14:22
 * @description:
 */
public class JunitTest {

    @Test
    public void factory(){
        AbstractFactory<Color> prodive = FactoryProdive.getFactory("color");
        Color color = prodive.getObject("black");
        System.out.println(color.getColor());
    }

    @Test
    public void factory2(){
        PersonCreatorFactory factory = new DefaultPersonCreatorFactory();
        Person person = factory.create("男");
        System.out.println(person);
        person.eat();
    }

}
