package zsy.thinkinjava;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            strings.add(String.valueOf((char) ('A' + i)));
        }
        System.out.println("1:" + Arrays.toString(strings.toArray()));

        List<String> subStrings = strings.subList(5, 10);
        System.out.println("2:" + Arrays.toString(subStrings.toArray()));

        subStrings.set(0, "123"); // subList()所产生的修改会反映到初始列表中，反之亦然。
        System.out.println("3:" + Arrays.toString(subStrings.toArray()));
        System.out.println("4:" + Arrays.toString(strings.toArray()));

        System.out.println("5: " + subStrings.retainAll(strings));
    }
}
