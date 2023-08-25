package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdIn;
import io.github.kangjinghang.chapter1_3.Stack;

/**
 * 编写一个 Stack 的用例 Parentheses，从标准输入中读取一个文本流并使用栈判定其中的括号是否配对完整。
 * 例如，对于 [()]{}{[()()]()} 程序应该打印 true，对于 [(]) 则打印 false。
 */
public class Parentheses {

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        String string = StdIn.readString();
        String[] inputs = string.split("");
        for (String item : inputs) {
            if (item.equals("[") || item.equals("(") || item.equals("{")) {
                s.push(item);
            } else if (item.equals("]")) {
                final String out = s.pop();
                if (!out.equals("[")) {
                    System.out.println(false);
                    return;
                }
            } else if (item.equals(")")) {
                final String out = s.pop();
                if (!out.equals("(")) {
                    System.out.println(false);
                    return;
                }
            } else if (item.equals("}")) {
                final String out = s.pop();
                if (!out.equals("{")) {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(s.isEmpty());
    }

}
