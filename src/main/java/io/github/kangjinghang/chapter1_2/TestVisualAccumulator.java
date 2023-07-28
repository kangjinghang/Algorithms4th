package io.github.kangjinghang.chapter1_2;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestVisualAccumulator {

    public static void main(String[] args) {
        // 需要绘出的点数
//        int T = Integer.parseInt(args[0]);
        int T = 2000;
        VisualAccumulator a = new VisualAccumulator(T, 1.0);
        for (int t = 0; t < T; t++) {
            a.addDataValue(StdRandom.uniformDouble());
        }
        StdOut.println(a);
    }

}
