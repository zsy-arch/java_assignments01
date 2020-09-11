package zsy.test3;

public class ThreadTest2 {
    public static Object object = new Object();
    public static Object object2 = new Object();
    public static int totalMoney = 10000;
    public static int account1 = 0; // 张三
    public static int account2 = 0; // 李四

    public static void main(String[] args) {
        Runnable r1 = () -> {
            synchronized (object) {
                account1 += 100;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                totalMoney -= 100;
            }
        };

        Runnable r2 = () -> {
            synchronized (object2) {
                account2 += 100;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                totalMoney -= 100;
            }
        };

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);

        t1.start();
        t2.start();

        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Bank: " + totalMoney);
        System.out.println("Zhangsan: " + account1);
        System.out.println("Lisi: " + account2);
    }
}

