package io.github.kangjinghang.chapter1_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 计算平均数
 * <p>
 * java-algs4 Average.java
 */
public class Average {

    public static void main(String[] args) {
        // 取StdIn中所有数的平均值
        double sum = 0.0D;
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            // 读取一个数并计算累计之和
            sum += StdIn.readDouble();
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }

}
