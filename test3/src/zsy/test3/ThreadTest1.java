package zsy.test3;

public class ThreadTest1 {
    public static final Object object = new Object();
    public static final Object object2 = new Object();
    static BankAccount account1 = new BankAccount("总账户", 10000);
    static BankAccount account2 = new BankAccount("张三", 0);
    static BankAccount account3 = new BankAccount("李四", 0);

    public static void main(String[] args) {

        ATMThread1 atmThread1 = new ATMThread1();
        ATMThread2 atmThread2 = new ATMThread2();

        Thread thread1 = new Thread(atmThread1);
        Thread thread2 = new Thread(atmThread2);

        thread1.start();
        thread2.start();


        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account1);
        System.out.println(account2);
        System.out.println(account3);
    }
}

class BankAccount {

    private String accountName;
    private int totalMoney;

    public BankAccount(String accountName, int totalMoney) {
        this.accountName = accountName;
        this.totalMoney = totalMoney;
    }


    public void deposit(int amount) {
        totalMoney += amount;
    }

    public void withdraw(int amount) {
        totalMoney -= amount;
    }

    public void transferTo(BankAccount to, int amount) {
        if (this.totalMoney >= amount) {
            to.deposit(amount);
            this.totalMoney -= amount;
        } else {
            System.out.println("Transfer failed.");
        }
    }

    public void transferFrom(BankAccount from, int amount) {
        if (from.totalMoney >= amount) {
            from.withdraw(amount);
            this.totalMoney += amount;
        } else {
            System.out.println("Transfer failed.");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountName='" + accountName + '\'' +
                ", totalMoney=" + totalMoney +
                '}';
    }
}

class ATMThread1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ThreadTest1.object) {
                ThreadTest1.account2.transferFrom(ThreadTest1.account1, 100);
            }
        }
    }
}

class ATMThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (ThreadTest1.object2) {
                ThreadTest1.account3.transferFrom(ThreadTest1.account1, 100);
            }
        }
    }
}