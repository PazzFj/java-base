package net.pazz.proxy;

/**
 * @author: 彭坚
 * @create: 2018/8/30 9:45
 * @description:
 */
public class DynamicBean implements SubDynamicBean {

    private String name;

    public DynamicBean() {
    }

    public DynamicBean(String name) {
        this.name = name;
    }

    public void testName(){
        System.out.println("name: " + this.name);
    }

}
