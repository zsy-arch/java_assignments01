package zsy.thinkinjava;

public class Test18 {
    public static void main(String[] args) {
        MyTable18 myTable18 = new MyTable18();
        String[] strings = new String[]{"Ada", "Bill", "Charles", "David", "Elizabeth"};
        for (String string : strings) {
            myTable18.add(string);
        }
        String s1;
        while ((s1 = myTable18.getName()) != null) {
            System.out.println(s1);
        }
        System.exit(-1);
        LinkedList18<String> stringLinkedList18 = new LinkedList18<>();
        for (String s : "Hello this is java application!".split(" ")) {
            stringLinkedList18.push(s);
        }
        String s;
        while ((s = stringLinkedList18.pop()) != null) {
            System.out.println(s);
        }
    }
}

class LinkedList18<T> {
    private static class Node<U> {
        U item;
        Node<U> next;

        Node() {
            item = null;
            next = null;
        }

        public Node(U item, Node<U> next) {
            this.item = item;
            this.next = next;
        }

        boolean end() {
            return item == null && next == null;
        }
    }

    private Node<T> top = new Node<>();

    public void push(T item) {
        top = new Node<>(item, top);
    }

    public T pop() {
        T result = top.item;
        if (!top.end()) {
            top = top.next;
        }
        return result;
    }
}

class MyTableElement18 {
    private String name;

    private MyTableElement18 nextEle;

    public MyTableElement18() {
    }

    public MyTableElement18(String name, MyTableElement18 nextEle) {
        this.name = name;
        this.nextEle = nextEle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTableElement18 getNextEle() {
        return nextEle;
    }

    public void setNextEle(MyTableElement18 nextEle) {
        this.nextEle = nextEle;
    }

    public boolean isEnd() {
        return (name == (null) && nextEle == (null));
    }
}

class MyTable18 {
    MyTableElement18 topEle = new MyTableElement18();

    public void add(String name) {
        topEle = new MyTableElement18(name, topEle);
    }

    public String getName() {
        String name = topEle.getName();
        if (!topEle.isEnd()) {
            topEle = topEle.getNextEle();
        }
        return name;
    }
}