package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Queue;
import io.github.kangjinghang.chapter1_3.Stack;

import java.util.List;

/**
 * 编写一段程序 EvaluatePostfix ，从标准输入中得到一个后序表达式，求值并打印结果（将上一题
 * 的程序中得到的输出用管道传递给这一段程序可以得到和 Evaluate 相同的行为）。
 */
public class EvaluatePostfix {

    public static void main(String[] args) {
        String string = "((1+21)*((3-4)*(5-60)))";
        // 转为中序表达式 list
        final List<String> infixExpressionList = InfixToPostfix.toInfixExpressionList(string);
        infixExpressionList.forEach(System.out::print);
        System.out.println();
        // 1 21 + 3 4 - 5 60 - * *
        // 22 -1 -55 * *
        // -22 -55 *
        // 1210
        final Queue<String> q = InfixToPostfix.infixToPostfix(infixExpressionList);
        System.out.println(q);

        evaluate(q);
    }

    public static void evaluate(Queue<String> q) {
        // 1 21 + 3 4 - 5 60 - * *
        // 22 -1 -55 * *
        // -22 -55 *
        // 1210
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            final String item = q.dequeue();
            if (item.matches("\\d+")) {
                // 操作数
                s.push(Integer.parseInt(item));
            } else {
                // 操作符
                final Integer v1 = s.pop();
                final Integer v2 = s.pop();
                if (item.equals("+")) {
                    s.push(v2 + v1);
                } else if (item.equals("-")) {
                    s.push(v2 - v1);
                } else if (item.equals("*")) {
                    s.push(v2 * v1);
                } else if (item.equals("/")) {
                    s.push(v2 / v1);
                }
            }
        }

        System.out.println(s.pop());
    }

}
