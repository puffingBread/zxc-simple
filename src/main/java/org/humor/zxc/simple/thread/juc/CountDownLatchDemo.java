package org.humor.zxc.simple.thread.juc;

import java.util.Arrays;
import java.util.Optional;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 让一线程阻塞直到另一些线程完成一系列操作才被唤醒。
 * <p>
 * CountDownLatch主要有两个方法（await()，countDown()）。
 * <p>
 * 当一个或多个线程调用await()时，调用线程（当前线程）会被阻塞。其它线程调用countDown()会将计数器减1(调用countDown方法的线程不会阻塞)，
 * 当计数器的值变为零时，因调用await方法被阻塞的线程会被唤醒，继续执行。
 * <p>
 * Date: 2021/10/18
 * Time: 5:50 下午
 *
 * @author xuzz
 */
public class CountDownLatchDemo {

    /**
     * 案例：秦灭六国，一同中原
     */
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        Object flag = 0;
        for (int i = 1; i < 7; i++) {

            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭了");
                countDownLatch.countDown();
                try {
                    Thread.sleep(3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, CountryEnum.of(i).getName()).start();
        }

        //主线程需等待其他线程执行完
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "秦国一统中原");

//        for (int i = 0; i < 6; i++) {
//            new Thread(() -> {
//                System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室 ");
//                countDownLatch.countDown();
//            }, String.valueOf(i)).start();
//
//        }
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(Thread.currentThread().getName() + "\t 班长最后关门");
    }


    enum CountryEnum {
        /**
         * 六国
         */
        ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕"), FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");
        private final Integer code;
        private final String name;

        CountryEnum(Integer code, String name) {
            this.code = code;
            this.name = name;
        }

        public static CountryEnum of(Integer code) {
            Optional<CountryEnum> optional = Arrays.stream(CountryEnum.values()).filter(e -> e.getCode().equals(code)).findFirst();
            return optional.orElse(null);
        }

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    }

}
