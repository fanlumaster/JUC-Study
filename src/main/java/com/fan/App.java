package com.fan;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        new Thread(() -> {
            System.out.println("线程 2 想要获取锁");
            lock.lock();
            System.out.println("线程 2 成功获取到锁");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程 2 释放锁");
            lock.unlock();
        }).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("线程 1 释放了一次锁");
        lock.unlock();
        System.out.println("线程 1 再次释放了一次锁");
        lock.unlock();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("线程 2 获取到锁之后");
        lock.lock();
        System.out.println("线程 1 再次获取到锁");
        lock.unlock();
    }
}
