package net.pazz.base;

/**
 * @Author: pengjian
 * @Date: 2018/5/4 13:54
 * @Description: NIO 方式
 */
public class FutureMain {

    public static void main(String[] args) throws Exception {
//        RealData rd = new RealData("pengjian");
//        FutureTask<String> futureTask = new FutureTask<>(rd);
//        //线程池
//        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.submit(futureTask);
//        System.out.println("请求完毕！");
//        try {
//            System.out.println("我在睡觉别打扰我！2秒后回应");
//            Thread.sleep(2000);
//            System.out.println("睡觉结束");
//        } catch (InterruptedException e) {
//
//        }
//        System.out.println("数据处理完成：" + futureTask.get());
//        //关闭数据池
//        executorService.shutdown();

        String[] one = new String[]{"aa", "bb", "cc", "dd"};

        String[] two = new String[]{"11", "22"};

        System.arraycopy(one, 1, two, 1, 1);
        for (int i = 0; i < two.length; i++) {
            System.out.println(two[i]);
        }
    }

}
