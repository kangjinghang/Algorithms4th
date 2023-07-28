package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.Accumulator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * Accumulator 的测试用例
 *
 * <p>
 * java-algs4 TestAccumulator.java 1000
 */
public class TestAccumulator {

    // java-algs4 TestAccumulator.java 1000
    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        Accumulator myAccumulator = new Accumulator();
        for (int t = 0; t < T; t++) {
            myAccumulator.addDataValue(StdRandom.uniformDouble());
        }
        // n = 1000, mean = 0.4976294110366479, stddev = 0.2898253756294088
        StdOut.println(myAccumulator);
    }

}
