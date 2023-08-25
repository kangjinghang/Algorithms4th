package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_3.Queue;

/**
 * Josephus 问题。在这个古老的问题中， N 个身陷绝境的人一致同意通过以下方式减少生存人
 * 数。他们围坐成一圈（位置记为 0 到 N-1）并从第一个人开始报数，报到 M 的人会被杀死，
 * 直到最后一个人留下来。传说中 Josephus 找到了不会被杀死的位置。编写一个 Queue 的用例
 * Josephus，从命令行接受N和M并打印出人们被杀死的顺序（这也将显示Josephus在圈中的位置）。
 *
 * <p>
 * 我们把问题描述如下：
 * <p>
 * <li>现有T个人围成一桌坐下，编号从1到T，从编号为1的人开始报数。
 * <li>报数也从1开始，报到M的人离席，从离席者的下一位在座成员开始，继续从1开始报数。
 * <li>复现这个过程（各成员的离席次序），或者求最后一个在座的成员编号。
 * <p>
 * 用队列实现了一个环状的结构，其核心就是利用队列“先进先出”的特点。又因为出列、入列都是 O(1) 的操作，所以时间复杂度也大大降低了，M为定值时，复杂度为 O(T)
 * 参考：<a href="https://zhuanlan.zhihu.com/p/35487124">...</a>
 */
public class Josephus {

    public static void main(String[] args) {
        int M = 3;
        int N = 41;
        Queue<Integer> q = new Queue<>();

        for (int i = 0; i < N; i++) {
            q.enqueue(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < M; i++) {
                if (i < M - 1) {
                    q.enqueue(q.dequeue());
                } else {
                    System.out.print(q.dequeue() + "\t");
                }
            }
        }

        System.out.println();
        System.out.println("不会被杀死的位置：" + q.dequeue());

    }

}
