package zsy.algs;

import java.util.Comparator;

public class Test3 {
    public static void main(String[] args) {
        Runnable printTask = System.out::println;
        printTask.run();
        Runnable printTask2 = ()->{
            System.out.println();
        };
        printTask2.run();
    }
}

interface MyInterface3 {
    int sum(int a, int b);
}

interface MyInterface3_2 {
    int subtract(int a, int b);

    int multiply(int a, int b);
}