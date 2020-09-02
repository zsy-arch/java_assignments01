package zsy.algs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Rewrite Test2.java
 */
public class Test4 {
    public static void main(String[] args) {
        Stack<Double> doubleStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        doubleStack.push(0.0);
        stringStack.push("+");
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while (scanner.hasNext()) {
            inputString = scanner.next();
            if (inputString.equals("(")) continue;
            else if (inputString.equals("+")) stringStack.push(inputString);
            else if (inputString.equals("-")) stringStack.push(inputString);
            else if (inputString.equals("*")) stringStack.push(inputString);
            else if (inputString.equals("/")) stringStack.push(inputString);
            else if (inputString.equals(")")) {
                String operation = stringStack.pop();
                double val1 = doubleStack.pop();
                if (operation.equals("+")) val1 = doubleStack.pop() + val1;
                else if (operation.equals("-")) val1 = doubleStack.pop() - val1;
                else if (operation.equals("*")) val1 = doubleStack.pop() * val1;
                else if (operation.equals("/")) val1 = doubleStack.pop() / val1;
                doubleStack.push(val1);
            } else {
                doubleStack.push(Double.parseDouble(inputString));
            }
        }
        if (!doubleStack.isEmpty()) {
            System.out.println(doubleStack.peek());
        }
    }
}

class Stack<T> {
    LinkedList<T> list = new LinkedList<>();

    public Stack() {
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(T t) {
        list.addFirst(t);
    }

    public T pop() {
        return list.pop();
    }

    public T peek() {
        return list.peek();
    }
}
