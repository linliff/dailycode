package com.linlif.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by linlif on 2020/7/1
 */
class ThreadPrint2 {

    private static Lock lock = new ReentrantLock();
    private static int state = 0;

    public static void main(String[] args) throws InterruptedException {

        Object a = new Object();
        Object b = new Object();
        Object c = new Object();

        try {
            new Thread(new MyRunnable("a", c, a)).start();
            Thread.sleep(10);
            new Thread(new MyRunnable("B", a, b)).start();
            Thread.sleep(10);
            new Thread(new MyRunnable("C", b, c)).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    private static class MyRunnable implements Runnable {

        private String name;
        private Object pre;
        private Object self;
        int count = 10;

        public MyRunnable(String name, Object pre, Object self) {

            this.name = name;
            this.pre = pre;
            this.self = self;

        }

        @Override
        public void run() {
            while (count > 0) {
                synchronized (pre) {

                    synchronized (self) {

                        System.out.println(name);
                        count--;
                        self.notifyAll();
                    }

                    try {
                        pre.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
