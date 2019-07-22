package net.pazz.base.string;

/**
 * @author: 彭坚
 * @create: 2018/8/24 9:47
 * @description:
 */
public class StrTest {

    public static void main(String[] args) {
//        String blNo = "ESHZ180241564C5C11";
        String blNo = "ESHZ1802415-64C5C-11";
        blNo = blNo.substring(0, blNo.indexOf("-"));
        System.out.println(blNo);

//        String[] strs = blNo.split("-");
//        System.out.println(strs.length);


    }

}
