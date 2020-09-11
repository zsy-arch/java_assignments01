package zsy.test3;

public class Test5 {
    static Object object=new Object();
    public static void main(String[] args) {
        Runnable runnable=() -> {
            while (true)
            {
                synchronized (object)
                {
                    System.out.println("looping...");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("out of syn block");
            }
        };

        Thread thread=new Thread(runnable);
        thread.start();

        try {
            Thread.sleep(1000*3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        synchronized (object) {
            object.notify();
        }
    }
}
