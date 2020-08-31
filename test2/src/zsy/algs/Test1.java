package zsy.algs;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Test1 {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        vals.push(0.0);
        ops.push("+");
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) ;
            else if (s.equals(",")) ; // ,
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("%")) ops.push(s);
            else if (s.equals("^")) ops.push(s);
            else if (s.equals("!")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals("log")) ops.push(s);
            else if (s.equals("logx")) ops.push(s);
            else if (s.equals("log10")) ops.push(s);
            else if (s.equals("log1p")) ops.push(s);
            else if (s.equals("loge")) ops.push(s);
            else if (s.equals("sin")) ops.push(s);
            else if (s.equals("cos")) ops.push(s);
            else if (s.equals("tan")) ops.push(s);
            else if (s.equals("PI")) vals.push(Math.PI);
            else if (s.equals("E")) vals.push(Math.E);
            else if (s.equals(")")) {
                if (ops.isEmpty()) break;
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("%")) v = vals.pop() % v;
                else if (op.equals("^")) v = Math.pow(vals.pop(), v);
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                else if (op.equals("!")) v = factorial(v); // !
                else if (op.equals("sin")) v = Math.sin(v);
                else if (op.equals("cos")) v = Math.cos(v);
                else if (op.equals("tan")) v = Math.tan(v);
                else if (op.equals("log")) v = Math.log(v);
                else if (op.equals("log10")) v = Math.log10(v);
                else if (op.equals("log1p")) v = Math.log1p(v);
                else if (op.equals("loge")) v = logE(v);
                else if (op.equals("logx")) v = logX(vals.pop(), v);
                vals.push(v);
            } else {
                vals.push(Double.parseDouble(s));
            }
        }
        StdOut.println(vals.pop());
    }

    public static double logE(double a) {
        return Math.log(a) / Math.log(Math.E);
    }

    public static double logX(double a, double b) {
        return Math.log(b) / Math.log(a);
    }

    public static double factorial(double a) {
        if (a == 1 || a == 0) return 1;
        return a * factorial(a - 1);
    }
}
