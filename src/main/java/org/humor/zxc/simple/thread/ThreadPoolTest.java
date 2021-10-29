package org.humor.zxc.simple.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Date: 2020/11/4
 * Time: 2:03 下午
 *
 * @author xuzz
 */
public class ThreadPoolTest {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 10, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            return null;
        }
    });

    public void execute() {

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            executor.submit(() -> {
                System.out.println("---" + Thread.currentThread().getName());
            });
        }
    }
}
