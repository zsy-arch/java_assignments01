package zsy.thinkinjava;

import java.util.Iterator;

public class Test20 {
    public static void main(String[] args) {
        IterableFibonacci iterableFibonacci = new IterableFibonacci(10);
        for (Integer integer : iterableFibonacci) {
            System.out.println(integer);
        }
    }
}

class Fibonacci {
    private int count = 0;

    public int next() {
        return fibonacci(count++);
    }

    private int fibonacci(int i) {
        if (i < 2) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }
}

// Adaptor of Fibonacci
class IterableFibonacci extends Fibonacci implements Iterable<Integer> {
    int n = 0;

    public IterableFibonacci(int n) {
        this.n = n;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return n > 0;
            }

            @Override
            public Integer next() {
                n--;
                return IterableFibonacci.this.next();
            }
        };
    }
}
