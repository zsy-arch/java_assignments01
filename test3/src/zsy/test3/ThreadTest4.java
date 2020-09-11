package zsy.test3;

import java.util.ArrayList;
import java.util.List;

public class ThreadTest4 {
    public static void main(String[] args) {
        List list = new ArrayList();
        Producer producer = new Producer(list);
        Consumer consumer = new Consumer(list);
        Thread thread1=new Thread(producer);
        Thread thread2 = new Thread(consumer);

        thread1.start();
        thread2.start();
    }
}

class Producer implements Runnable {
    List list;

    public Producer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list) {
                if (list.size() > 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (list.size() == 0) {
                    Object o = new Object();
                    list.add(o);
                    System.out.println("Produced a object: " + o);
                    list.notify();
                }
            }
        }    }
}

class Consumer implements Runnable {
    List list;

    public Consumer(List list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list) {
                if (list.size() > 0) {
                    Object o = list.remove(0);
                    System.out.println("Consumed a object: " + o);
                    list.notify();
                }
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }    }
}