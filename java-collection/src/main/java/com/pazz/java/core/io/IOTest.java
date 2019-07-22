package com.pazz.java.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author: 彭坚
 * @create: 2018/12/25 9:43
 * @description:
 */
public class IOTest {

    public static void main(String[] args) throws Exception {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f:/images/12.CHM"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("f:/images/1234.CHM"));
        byte[] b = new byte[1024];
        while (bis.read(b) != -1) {
            bos.write(b);
        }
        bos.close();
        bis.close();
    }

}
