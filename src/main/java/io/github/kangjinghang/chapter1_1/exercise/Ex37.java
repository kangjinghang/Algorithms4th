package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 糟糕的打乱。假设在我们的乱序代码中你选择的是一个 0 到 N-1 而非 i 到 N-1 之间的随机整数。
 * 证明得到的结果并非均匀地分布在 N! 种可能性之间。用上一题中的测试检验这个版本。
 */
public class Ex37 {

    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // between i and N-1
            // 选择 i 到 N-1 之间的随机整数 r
            int r = StdRandom.uniformInt(N);
            // a[i] 与 a[r] 互换，打乱
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args) {
//        if (args.length < 2) {
//            System.out.println("Error");
//            return;
//        }
        // 大小为 M 的数组
//        int M = Integer.parseInt(args[0]);
        int M = 5;
        // 打乱 N 次
//        int N = Integer.parseInt(args[1]);
        int N = 10000;

        int[] a = new int[M];
        int[][] num = new int[M][M];

        // 打乱 N 次
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 在每次打乱之前都将数组重新初始化为 a[i] = i
                a[j] = j;
            }
            // 打乱
            shuffle(a);
            for (int j = 0; j < M; j++) {
                // a[j] 表示原来位置为 j 的元素在打乱后落到了 a[j] 的位置
                // num[a[j]][j] 表示原来位置为 j 的元素在打乱后落到了 a[j] 的次数，竖向 j 是打乱前位置，横向 a[j] 是打乱后位置
                num[a[j]][j]++;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                // 数组中的所有元素的值都应该接近于 N/M
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

}
