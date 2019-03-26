package net.pazz.base.future;

import java.util.concurrent.Callable;

/**
 * @Author: pengjian
 * @Date: 2018/5/4 11:20
 * @Description: 真实数据 {@link Callable<String>}
 */
public class RealData implements Callable<String> {

    private String para;

    public RealData(String para){
        this.para = para;
    }

    @Override
    public String call() throws Exception {
        //真实的业务逻辑
        StringBuilder sb = new StringBuilder();
        for (int i= 0 ;i < 10 ; i++){
            sb.append(para);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

}
