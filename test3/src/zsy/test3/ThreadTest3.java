package zsy.test3;

public class ThreadTest3 {
    public static void main(String[] args) {
        Object o = new Object();
        MyThread3 myThread3 = new MyThread3(o);
        Thread thread = new Thread(myThread3);
        thread.start();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

class MyThread3 implements Runnable {
    Object object;
    private int i = 0;

    public MyThread3(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object) {
            while (true) {
                i++;
                System.out.println(i);
//                if (i == 10) {
//                    try {
//                        object.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
                if (Thread.interrupted()) {
                    System.out.println("!!!!!");
                    break;
                }
            }
        }
    }
}
