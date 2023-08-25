package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Queue;
import io.github.kangjinghang.chapter1_3.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个过滤器 InfixToPostfix，将算术表达式由中序表达式转为后序表达式。
 *
 * <p>
 * <a href="https://blog.csdn.net/qq_34834846/article/details/89406361">调度场算法</a>
 * <p>
 * 创建一个操作数队列和一个操作数栈
 * 遇到操作数则送入队列
 * 遇到操作符则送入栈
 * 遇到其他运算符：
 * 加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
 * 遇到 ）括号则将栈内从 （ 到 ）的所有操作符全部取出送入队列
 * 表达式分类完成后，先输出队列内容，再输出栈内容，前者+后者便是后序表达式
 *
 * <p>
 * 还是将（...）当成一个整体来看，不用计算结果，但是整体当作一个操作数，一起压入到操作数栈
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String string = "((1+21)*((3-4)*(5-60)))";
        // 转为中序表达式 list
        final List<String> infixExpressionList = toInfixExpressionList(string);
        infixExpressionList.forEach(System.out::print);
        System.out.println();
        final Queue<String> q = infixToPostfix(infixExpressionList);
        System.out.println(q);
    }

    /**
     * "((1+21)*((3-4)*(5-60)))" -> 中序 list
     */
    public static List<String> toInfixExpressionList(String s) {
        // 定义一个List,存放 中缀表达式 对应的内容
        List<String> res = new ArrayList<>();
        // 一个指针，用于遍历 中缀表达式字符串
        int i = 0;
        // 每遍历到一个字符，就放入到c
        do {
            char c = s.charAt(i);
            // 如果c是一个非数字，即操作符，直接加入到 res
            if (isOperator(c)) {
                res.add(c + "");
                i++;
            } else {
                // 如果是一个数，需要考虑多位数
                // 先将str 置成"" '0'[48]->'9'[57]
                // 对多位数的拼接
                String numStr = "";
                while (i < s.length() && isNumber((c = s.charAt(i)))) {
                    numStr += c;
                    i++;
                }
                res.add(numStr);
            }

        } while (i < s.length());
        return res;
    }

    public static Queue<String> infixToPostfix(List<String> ls) {
        // 操作符栈
        Stack<String> s = new Stack<>();
        // 操作数队列
        Queue<String> q = new Queue<>();
        for (String item : ls) {
            // 如果是一个数字，加入 q
            if (item.matches("\\d+")) {
                q.enqueue(item);
            } else if (item.equals("(")) {
                s.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号 ")"，则依次弹出 s 栈顶的运算符，并压入 q，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s.peek().equals("(")) {
                    // 反向，将 （） 左右括号包裹的表达式，当作一个操作数的整体，进入到操作数队列，这样的话就是先进先出，括号内的会被首先计算
                    q.enqueue(s.pop());
                }
                // !!! 将 ( 弹出 s1栈， 消除左小括号
                s.pop();
            } else {
                // 是 +-*/ 运算符
                // 当 item 的优先级小于等于 s 栈顶运算符（s 栈顶运算符优先级更高）， 将 s 栈顶的运算符弹出并加入到 q 中，然后继续循环，与 s 中新的栈顶运算符相比较
                // 因为 item 的优先级低，所以又需要将高优先级的表达式当作一个整体加入到操作数队列。因为操作数已经入队，只要将 s 的操作数入到 q 即可
                // 问题：我们缺少一个比较优先级高低的方法
                while (!s.isEmpty() && Operation.getValue(s.peek()) >= Operation.getValue(item)) {
                    q.enqueue(s.pop());
                }
                // 还需要将item压入栈
                s.push(item);
            }
        }

        // 将 s 中剩余的运算符依次弹出并加入 q（ s 的操作符逆序）
        while (!s.isEmpty()) {
            q.enqueue(s.pop());
        }
        // 注意因为是存放到 q, 因此按顺序输出就是对应的后缀表达式对应的 q
        return q;
    }

    private static boolean isOperator(char c) {
        return c < 48 || c > 57;
    }

    private static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

}

class Operation {

    private Operation() {
    }

    private static final int ADD = 1;

    private static final int SUB = 1;

    private static final int MUL = 2;

    private static final int DIV = 2;

    /**
     * 返回操作符的优先级
     */
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.err.println("不存在该运算符:" + operation);
                break;
        }
        return result;
    }

}
