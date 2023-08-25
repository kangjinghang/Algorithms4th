package io.github.kangjinghang.chapter1_3.exercise;

import edu.princeton.cs.algs4.StdIn;
import io.github.kangjinghang.chapter1_3.Queue;

/**
 * 编写一个 Queue 的用例，接受一个命令行参数 k 并打印出标准输入中的倒数第 k 个字符串（假
 * 设标准输入中至少有 k 个字符串）。
 */
public class Ex15 {

    public static void main(String[] args) {
//        int k = Integer.parseInt(args[0]);
        int k = 4;
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }

        // 假设：k =1，q.size() = 4
        int i = 0;
        while (i < (q.size() - k)) {
            // i < 3
            q.dequeue();
        }
        System.out.println(q.dequeue());
    }

}
