package com.linlif.thread;


/**
 * Copyright (c) 2020 Tencent. All rights reserved.
 * 类功能描述:
 *
 * @author lifenglin
 * @date 2024/3/5
 */
public class ThreadPrit {

    public static int count = 1;
    public static Object tmp = new Object();

    public static void main(String[] args) throws InterruptedException {

        int[] sss = new int[]{1, -2, 2, 4};
        test2(sss);
    }

    public static void test() {
        Thread t1 = new Thread(new PrintThread(1));
        Thread t2 = new Thread(new PrintThread(2));
        Thread t3 = new Thread(new PrintThread(3));

        t1.start();
        t2.start();
        t3.start();
    }

    static class PrintThread implements Runnable {

        public int threadId;

        public PrintThread(int threadId) {
            this.threadId = threadId;
        }

        public void run() {
            int i = 1;
            while (i < 10) {
                synchronized (tmp) {
                    System.out.println("ThreadId :" + threadId + "count :" + (count % 3 + 1));
                    count++;
                    i++;
                    tmp.notifyAll();
                }
            }
        }
    }

    public static int test2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp = Math.max(nums[i] + temp, nums[i]);
            max = Math.max(max, temp);
            System.out.println("i = " + i);
            System.out.println("temp = " + temp);
            System.out.println("max = " + max);
        }
        System.out.println("max :" + max);

        return max;
    }
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (count < 10) {
//                    synchronized (tmp) {
//                        System.out.println("1");
//                        count++;
//                        tmp.notifyAll();
//                        try {
//                            tmp.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        });
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (count < 10) {
//                    synchronized (tmp) {
//                        System.out.println("2");
//                        count++;
//                        tmp.notifyAll();
//                        try {
//                            tmp.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();
}

