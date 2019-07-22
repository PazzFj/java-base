package net.pazz.base.generics;

/**
 * @author: Peng Jian
 * @date: 2018/6/4 14:16
 * @description:
 */
public class Sub extends Parent {

    private String address;

    public Sub(String address) {
        super("name");
        System.out.println("address: " + address);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
