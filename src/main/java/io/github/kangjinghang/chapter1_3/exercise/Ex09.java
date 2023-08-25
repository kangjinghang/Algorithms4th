package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdIn;
import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 编写一段程序，从标准输入得到一个缺少左括号的表达式并打印出补全括号之后的中序表达式。
 * 例如，给定输入：
 * 1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
 * 你的程序应该输出：
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 */
public class Ex09 {

    public static void main(String[] args) {
        // 双栈
        // 操作符栈
        Stack<String> ops = new Stack<>();
        // 操作数栈
        Stack<String> vals = new Stack<>();
        String string = StdIn.readLine();
        String[] inputs = string.split(" ");
        for (String item : inputs) {
            if (isOperator(item)) {
                ops.push(item);
            } else if (item.equals(")")) {
                final String v1 = vals.pop();
                final String v2 = vals.pop();
                final String op = ops.pop();
                // op 从 ops 中出栈，加上 v2 和 v1，组成 s，把 s 当作一个整体，加入到 操作数栈 中
                String s = "( " + v2 + " " + op + " " + v1 + " " + ")";
                vals.push(s);
            } else {
                vals.push(item);
            }

        }

        System.out.println(vals.pop());
    }


    private static boolean isOperator(String s) {
        return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"));
    }

}
