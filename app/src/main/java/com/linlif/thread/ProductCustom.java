package com.linlif.thread;

import java.util.LinkedList;

/**
 * Created by linlif on 2020/7/1
 */
class ProductCustom {

    public static void main(String[] args) throws InterruptedException {

        LinkedList linkedList = new LinkedList<Integer>();

        try {
            new ProThread(linkedList).start();

            Thread.sleep(10);
            new CusThread(linkedList).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    static class ProThread extends Thread {

        private LinkedList linkedList;

        public ProThread(LinkedList linkedList) {
            this.linkedList = linkedList;
        }

        public void run() {
            synchronized (linkedList) {

                for (int i = 0; i < 9; i++) {

                    while (linkedList.size() > 0) {
                        try {
                            System.out.println("product  wait " + i);
                            linkedList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    linkedList.add(i);
                    System.out.println("product  + " + i);
                    linkedList.notify();
                }
            }


        }
    }


    static class CusThread extends Thread {

        private LinkedList linkedList;

        public CusThread(LinkedList letter) {
            this.linkedList = letter;
        }

        public void run() {

            synchronized (linkedList) {
                while (true) {

                    if (linkedList.size() == 0) {
                        try {
                            System.out.println("cus  wait ");
                            linkedList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Object poll = linkedList.poll();
                    System.out.println("cus  + " + poll);
                    linkedList.notify();
                }

            }
        }

    }
}