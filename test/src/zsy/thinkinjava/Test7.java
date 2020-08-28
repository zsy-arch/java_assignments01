package zsy.thinkinjava;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class Test7 {
    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 > o2 ? 1 : (o1.equals(o2) ? 0 : -1));
            }
        });

        Random random = new Random(47);
        for (int i = 0; i < 20; i++) {
            integers.add(random.nextInt(100));
        }

        integers.forEach(System.out::println);
    }
}
