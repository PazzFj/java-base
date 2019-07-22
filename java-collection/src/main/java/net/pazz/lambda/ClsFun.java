package net.pazz.lambda;

/**
 * @author 彭坚
 * @create 2018/9/13 22:03
 * @description: 函数使用
 */
public class ClsFun {

    public String testFun(Func func, String str){
        func.createStr(str, str);
        return str;
    }

}
