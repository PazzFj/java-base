package net.pazz.design;

import net.pazz.design.proxy.Image;
import net.pazz.design.proxy.ProxyImage;

/**
 * @description 代理模式
 * 应用实例：
 * 1、Windows 里面的快捷方式。
 * 2、猪八戒去找高翠兰结果是孙悟空变的，可以这样理解：把高翠兰的外貌抽象出来，高翠兰本人和孙悟空都实现了这个接口，猪八戒访问高翠兰的时候看不出来这个是孙悟空，所以说孙悟空是高翠兰代理类。
 * 3、买火车票不一定在火车站买，也可以去代售点。
 * 4、一张支票或银行存单是账户中资金的代理。支票在市场交易中用来代替现金，并提供对签发人账号上资金的控制。
 * 5、spring aop。
 * <p>
 * 使用场景：按职责来划分，通常有以下使用场景：
 * 1、远程代理。
 * 2、虚拟代理。
 * 3、ReflectionUtil-on-Write 代理。
 * 4、保护（Protect or Access）代理。
 * 5、Cache代理。
 * 6、防火墙（Firewall）代理。
 * 7、同步化（Synchronization）代理。
 * 8、智能引用（Smart Reference）代理。
 */
public class ProxyExample {

    public static void main(String[] args) {
        Image image = new ProxyImage("test_10mb.jpg");
        //图像将从磁盘加载
        image.display();
        System.out.println("");
        //图像将无法从磁盘加载
        image.display();
    }

}
