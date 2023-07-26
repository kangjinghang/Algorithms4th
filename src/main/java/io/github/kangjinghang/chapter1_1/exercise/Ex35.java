package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 模拟掷骰子。以下代码能够计算每种两个骰子之和的准确概率分布：
 * <p>
 * int SIDES = 6;
 * double[] dist = new double[2*SIDES+1];
 * for (int i = 1; i <= SIDES; i++)
 * for (int j = 1; j <= SIDES; j++)
 * dist[i+j] += 1.0;
 * for (int k = 2; k <= 2*SIDES; k++)
 * dist[k] /= 36.0;
 * <p>
 * dist[i] 的值就是两个骰子之和为 i 的概率。用实验模拟 N 次掷骰子，并在计算两个 1 到 6 之间的随机整数之和时记录每个值的出现频率以验证它们的概率。N 要多大才能够保证你
 * 的经验数据和准确数据的吻合程度达到小数点后三位？
 */
public class Ex35 {

    public static void main(String[] args) {
        int SIDES = 6;
        // 第 0 和 第 1 个元素不统计 [1,12]
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++) { // 第一个骰子，点数为 i
            for (int j = 1; j <= SIDES; j++) { // 第二个骰子，点数为 j
                // dist[i + j] 的值就是两个骰子之和为 i + j 的概率，首先都初始化为1
                // 2	3	4	5	6	7
                // 3	4	5	6	7	8
                // 4	5	6	7	8	9
                // 5	6	7	8	9	10
                // 6	7	8	9	10	11
                // 7	8	9	10	11	12
                // 两者和为 7 的可能性最高
                dist[i + j] += 1.0;
//                System.out.print(i+j);
//                System.out.print("\t");
            }
//            System.out.println();
        }
        // [0.0, 0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 4.0, 3.0, 2.0, 1.0]
        System.out.print("Probability:");
        for (int k = 2; k <= 2 * SIDES; k++) {
            // 计算概率，6 * 6 = 36 种可能性
            dist[k] /= 36.0;
            System.out.printf("%6.3f", dist[k]);
        }
        System.out.println();
        int[] num = new int[2 * SIDES + 1];
        // 掷 N 次骰子
//        int N = StdIn.readInt();
        int N = 1000000;
        for (int i = 0; i < N; i++) {
            // StdRandom.discrete(dist) 概率为 dist[i] 时返回 i
            num[StdRandom.discrete(dist)]++; // i 的次数+1
        }
        double frequency;
        boolean isAccurate = true;
        System.out.print("Frequency:");
        for (int i = 2; i <= 2 * SIDES; i++) { // [1,12]
            frequency = (double) num[i] / N; // 两个骰子之和为 i 的真实频率
            System.out.printf("%6.3f", frequency);
            if (Math.abs(frequency - dist[i]) > 0.001) { // 误差在 0.001 内则为离散
                isAccurate = false;
            }
        }
        System.out.println();
        System.out.println("Is accurate? " + isAccurate);
    }

}
