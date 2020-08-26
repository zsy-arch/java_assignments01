package zsy.thinkinjava;

import java.util.*;

// 11.6 Iteration
public class Test3 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            integers.add(1000);
        }

        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
//            iterator.remove();
        }
        System.out.println("==================");
        for (Integer integer : integers) {
            System.out.println("I: " + integer);
        }
        System.out.println("==================");
        ListIterator<Integer> listIterator = integers.listIterator(1);
        while (listIterator.hasNext()) {
            listIterator.set(100);
            listIterator.next();
        }
        for (Integer integer : integers) {
            System.out.println("I: " + integer);
        }
    }
}
