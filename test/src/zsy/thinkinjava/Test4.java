package zsy.thinkinjava;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test4 {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        ListIterator<Integer> integerListIterator = integers.listIterator();
        for (int i = 1; i <= 10; i++) {
            integerListIterator.add(i * i);
        }
        integers.forEach(System.out::println);
        System.out.println();
        insert(integers.listIterator((integers.size() / 2)), new Integer[]{1, 2, 3, 4, 5});
        integers.forEach(System.out::println);
        System.out.println();
    }

    public static void insert(ListIterator iterator, Integer[] integers) {
        for (Integer integer : integers) {
            iterator.add(integer);
        }
    }

}
