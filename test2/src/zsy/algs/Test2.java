package zsy.algs;

public class Test2 {
    public static void main(String[] args) {
        MyFixedCapacityStackOfStrings stackOfStrings = new MyFixedCapacityStackOfStrings(5);
        stackOfStrings.push("H");
        stackOfStrings.push("H");
        stackOfStrings.push("H");
        stackOfStrings.push("H");
        stackOfStrings.push("H");
        for (int i = 0; i < 5; i++) {
            System.out.println(stackOfStrings.pop());
        }
    }
}

class MyFixedCapacityStackOfStrings {
    private String[] strings;
    private int N;

    public MyFixedCapacityStackOfStrings(int cap) {
        strings = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String s) {
        if (N >= strings.length) {
            throw new RuntimeException("Out of index");
        }
        strings[N++] = s;
    }

    public String pop() {
        if (N < 0) {
            throw new RuntimeException("No such element");
        }
        return strings[--N];
    }


}