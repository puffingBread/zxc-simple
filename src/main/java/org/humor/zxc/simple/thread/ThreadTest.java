package org.humor.zxc.simple.thread;

/**
 * 多线程实现方式
 * Date: 2021/10/9
 * Time: 2:57 下午
 *
 * @author xuzz
 */
public class ThreadTest {

    private static final Object LOCK = new Object();

    private static int COUNT = 10;

    /**
     * 继承Thread类，重写run方法
     */
    static class TThread extends Thread {

        @Override
        public void run() {
            while (COUNT > 0) {
                synchronized (LOCK) {
                    if (COUNT % 2 == 0) {
                        System.out.print("Hello ");
                        COUNT--;
                        LOCK.notifyAll();
                        try {
                            if (COUNT > 0) {
                                LOCK.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }

    }

    /**
     * 实现Runnable接口，重写run方法
     */
    static class RunThread implements Runnable {

        @Override
        public void run() {
            while (COUNT > 0) {
                synchronized (LOCK) {
                    if (COUNT % 2 == 1) {
                        System.out.println("World!");
                        COUNT--;
                        LOCK.notifyAll();
                        try {
                            if (COUNT > 0) {
                                LOCK.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) {


        TThread tThread = new TThread();
        tThread.start();

        RunThread runThread = new RunThread();
        runThread.run();

    }
}
