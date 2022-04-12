package com.fan.volatilestudy;

public class Test02 {
    private static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                a++;
            }
            System.out.println("任务完成！");
        };
        new Thread(r).start();
        new Thread(r).start();

        // 等待线程执行完成
        Thread.sleep(1000);
        System.out.println(a); // 不保证原子性
    }
}
