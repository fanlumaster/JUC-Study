package com.fan.volatilestudy;

public class Test01 {
    private static volatile int a = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (a == 0)
                ;
            System.out.println("线程结束！");
        }).start();

        Thread.sleep(1000);
        System.out.println("正在修改 a 的值...");
        a = 1;
    }
}
