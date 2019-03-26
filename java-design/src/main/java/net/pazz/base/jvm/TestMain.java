package net.pazz.base.jvm;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

    public void checkStackOut(){
        while(true){
            List<String> list = new ArrayList<>(2000);
        }
    }
    int x = 1;
    public void checkHeapOut(){
        x++;
        this.checkHeapOut();
    }

    public static void main(String[] args) {
        TestMain main = new TestMain();
        main.checkStackOut();//栈溢出
        main.checkHeapOut();//堆溢出
    }

}
