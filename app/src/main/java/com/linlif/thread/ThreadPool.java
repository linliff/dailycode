package com.linlif.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by linlif on 2020/8/3
 */
class ThreadPool {

    public static void main(String[] args) throws InterruptedException {


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 8, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(30));

        MyThread myThread1 = new MyThread("1");
        MyThread myThread2 = new MyThread("2");
        MyThread myThread3 = new MyThread("3");
        MyThread myThread4 = new MyThread("4");
        MyThread myThread5 = new MyThread("5");
        MyThread myThread6 = new MyThread("6");
        MyThread myThread7 = new MyThread("7");
        MyThread myThread8 = new MyThread("8");

        threadPoolExecutor.execute(myThread1);
        threadPoolExecutor.execute(myThread2);
        threadPoolExecutor.execute(myThread3);
        threadPoolExecutor.execute(myThread4);
        threadPoolExecutor.execute(myThread5);
        threadPoolExecutor.execute(myThread6);
        threadPoolExecutor.execute(myThread7);
        threadPoolExecutor.execute(myThread8);
    }

    private static class MyThread implements Runnable {

        private String name;

        public MyThread(String a) {
            name = a;
        }

        @Override
        public void run() {
            System.out.println(name + "  start");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(name + "  end");
        }
    }
}
