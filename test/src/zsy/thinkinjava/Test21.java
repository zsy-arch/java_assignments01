package zsy.thinkinjava;

import java.util.Scanner;

public class Test21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            System.out.println(isPrime(i));
        }
    }

    public static boolean isPrime(int i) {
        if (i < 2) return false;
        int sqrtOfi = (int) Math.sqrt(i);
        for (int j = 2; j <= sqrtOfi; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}

