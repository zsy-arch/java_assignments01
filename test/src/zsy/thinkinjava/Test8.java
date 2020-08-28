package zsy.thinkinjava;

import java.util.Scanner;

public class Test8 {
    public static void main(String[] args) {
        double i1 = 0, i2 = 0, t = 1, res = 0;
        Scanner scanner = new Scanner(System.in);
        while (t == 1) {
            System.out.printf("Value[1]: ");
            if (scanner.hasNext())
                i1 = scanner.nextDouble();
            System.out.printf("Value[2]: ");
            if (scanner.hasNext())
                i2 = scanner.nextDouble();
            try {
                res = calculate(i1, i2);
                System.out.println(res);
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println();
                t = 0;
            }
            
        }
    }

    public static double calculate(double i1, double i2) throws Exception {
        if (i2 == 0) throw new Exception("i2 cannot be zero.");
        return i1 / i2;
    }
}
