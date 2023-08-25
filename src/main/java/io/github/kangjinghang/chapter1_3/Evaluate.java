package io.github.kangjinghang.chapter1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

/**
 * 算术表达式求值
 * <p>
 * 表达式由括号、运算符和操作数（数字）组成。我们根据以下 4 种情况从左到右逐个将这些实体送入栈处理：
 * <li>将操作数压入操作数栈；
 * <li>将运算符压入运算符栈；
 * <li>忽略左括号；
 * <li>在遇到右括号时，弹出一个运算符，弹出所需数量的操作数，并将运算符和操作数的运算结果压入操作数栈。
 * <p>
 * 在处理完最后一个右括号之后，操作数栈上只会有一个值，它就是表达式的值。
 * <p>
 * ( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )
 * ( 1 + ( 5 * ( 4 * 5 ) ) )
 * ( 1 + ( 5 * 20 ) )
 * ( 1 + 100 )
 * 101
 */
public class Evaluate {

    public static void main(String[] args) {
        Stack<Character> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        while (!StdIn.isEmpty()) {
            // 读取字符，如果是运算符则压入栈
            final char c = StdIn.readChar();
            if (c == '(') {
                // ignore
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                ops.push(c);
            } else if (c == ')') {
                // 如果字符为 ")"，弹出运算符和操作数，计算结果并压入栈
                char op = ops.pop();
                double v = vals.pop();
                if (op == '+') {
                    v = vals.pop() + v;
                } else if (op == '-') {
                    v = vals.pop() - v;
                } else if (op == '*') {
                    v = vals.pop() * v;
                } else if (op == '/') {
                    v = vals.pop() / v;
                }
                vals.push(v);
            } else {
                // 如果字符既非运算符也不是括号，将它作为 double 值压入栈
                vals.push(Double.parseDouble(String.valueOf(c)));
            }
        }

        // (1+((2+3)*(4*5)))
        // ^D
        // 101.0
        StdOut.println(vals.pop());
    }

}
