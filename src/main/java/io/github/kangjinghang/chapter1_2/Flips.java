package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 模拟 T 次掷硬币
 */
public class Flips {

    public static void main(String[] args) {
//        int T = Integer.parseInt(args[0]);
        int T = 100000;

        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");

        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli(0.5)) {
                heads.increment();
            } else {
                tails.increment();
            }
        }

        StdOut.println(heads);
        StdOut.println(tails);
        int d = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(d));
        // 49587 heads
        // 50413 tails
        // delta: 826
    }

}
