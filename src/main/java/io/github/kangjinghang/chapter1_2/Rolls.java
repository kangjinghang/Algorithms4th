package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 模拟的是掷骰子。它使用了一个 Counter 对象的数组来记录每种可能的值的出现次数
 */
public class Rolls {

    public static void main(String[] args) {
//        int T = Integer.parseInt(args[0]);
        int T = 100000;
        int SIDES = 6;
        Counter[] rolls = new Counter[1 + SIDES];
        for (int i = 1; i <= SIDES; i++) {
            // 初始化 6 种可能性
            rolls[i] = new Counter(i + "'s");
        }

        for (int i = 0; i < T; i++) {
            int result = StdRandom.uniformInt(1, SIDES + 1);
            rolls[result].increment();
        }

        for (int i = 1; i <= SIDES; i++) {
            StdOut.println(rolls[i]);
        }

    }

}
