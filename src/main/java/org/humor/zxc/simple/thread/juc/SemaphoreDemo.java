package org.humor.zxc.simple.thread.juc;

import java.util.concurrent.Semaphore;

/**
 * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * 正常的锁(concurrency.locks或synchronized锁)在任何时刻都只允许一个任务访问一项资源，而 Semaphore允许n个任务同时访问这个资源。
 * <p>
 * Date: 2021/10/18
 * Time: 5:51 下午
 *
 * @author xuzz
 */
public class SemaphoreDemo {


    /**
     * 模拟一个抢车位的场景，假设一共有6个车，3个停车位
     */
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, false);

        for (int i = 1; i < 7; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");

                    Thread.sleep(3000L);

                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
