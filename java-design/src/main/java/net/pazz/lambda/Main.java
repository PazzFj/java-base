package net.pazz.lambda;

/**
 * @author 彭坚
 * @create 2018/9/13 22:02
 * @description: 测试
 */
public class Main {

    public static void main(String[] args) {
        ClsFun clsFun = new ClsFun();
        String str = clsFun.testFun((ss, qq) -> {
            System.out.println(ss + " qq:"+qq);
        }, "FUNCTION");
    }

}
