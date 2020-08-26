package zsy.thinkinjava;

import java.util.LinkedList;

// 11.8
public class Test5 {
    public static void main(String[] args) {
        String code = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+-+r+u--+l+e+s---";
        char[] codeArr = code.toCharArray();
        LinkedList<Character> characters = new LinkedList<>();
        MyStack<Character> myStack = new MyStack<Character>(characters);
        for (int i = 0; i < codeArr.length; i++) {
            if (codeArr[i] == '+') {
                if (i + 1 < codeArr.length) {
                    if (codeArr[i + 1] != '-' && codeArr[i + 1] != '+') {
                        myStack.push(codeArr[i + 1]);
                        i++;
                        continue;
                    }
                }
            }
            if (codeArr[i] == '-') {
                if (!myStack.empty()) {
                    System.out.println(myStack.pop());
                }
            }
        }
    }
}

class MyStack<T> {
    private LinkedList<T> list;

    public MyStack(LinkedList<T> list) {
        this.list = list;
    }

    public void push(T t) {
        list.addFirst(t);
    }

    public T peek() {
        return list.getFirst();
    }

    public T pop() {
        return list.removeFirst();
    }

    public boolean empty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
