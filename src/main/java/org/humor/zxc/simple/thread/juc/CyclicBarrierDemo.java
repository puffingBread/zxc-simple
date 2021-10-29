package org.humor.zxc.simple.thread.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的字面意思就是可循环（Cyclic）使用的屏障（Barrier）。它要求做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，
 * 直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活，线程进入屏障通过CyclicBarrier的await方法。
 * <p>
 * CyclicBarrier与CountDownLatch的区别：CyclicBarrier可重复多次，而CountDownLatch只能是一次。
 * <p>
 * Date: 2021/10/18
 * Time: 5:53 下午
 *
 * @author xuzz
 */
public class CyclicBarrierDemo {


    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {

            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " 收集到第" + temp + "颗龙珠");

                //拦截所有线程，到达设定值parties才执行
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();

        }

    }
}
