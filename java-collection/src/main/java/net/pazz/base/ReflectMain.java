package net.pazz.base;

import net.pazz.base.entity.Example;
import org.springframework.beans.BeanUtils;

/**
 * @author: Peng Jian
 * @date: 2018/7/13 17:31
 * @description:
 */
public class ReflectMain {

    public static void main(String[] args) {
        Example example1 = new Example();
        example1.setCode("code1");
        example1.setName("name1");
        Example example2 = new Example();
        example2.setCode("code2");
        example2.setName("name2");

        BeanUtils.copyProperties(example1, example2, "name");
        System.out.println(example1);
        System.out.println(example2);


    }

}
