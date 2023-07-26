package io.github.kangjinghang.chapter1_1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 打印N个(lo, hi)之间的随机值
 * <p>
 * java-algs4 RandomSeq.java 10 100.1 299.9
 */
public class RandomSeq {

    public static void main(String[] args) {
        // 打印N个(lo, hi)之间的随机值
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);

        for (int i = 0; i < N; i++) {
            final double val = StdRandom.uniformDouble(lo, hi);
//            StdOut.printf("(%d) %.2f\n", i + 1, val);
            StdOut.printf("%.2f\n", val);
        }
    }

}
