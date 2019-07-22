package net.pazz.reflect;

/**
 * @author: 彭坚
 * @create: 2018/9/10 15:57
 * @description:
 */
public class ReflectEntity extends ReflectParentEntity {

    private String name;
    public int age;
    private static final String tag;

    static {
        tag = "TAG_1";
    }

    private ReflectEntity(){

    }

    public ReflectEntity(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getTag() {
        return tag;
    }
}
