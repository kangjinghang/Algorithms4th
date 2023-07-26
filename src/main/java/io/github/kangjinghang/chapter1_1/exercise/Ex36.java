package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdRandom;

/**
 * 乱序检查。通过实验检查表 1.1.10 中的乱序代码是否能够产生预期的效果。编写一个程序
 * ShuffleTest，接受命令行参数 M 和 N，将大小为 M 的数组打乱 N 次且在每次打乱之前都将数组
 * 重新初始化为 a[i] = i。打印一个 M×M 的表格，对于所有的列 j，行 i 表示的是 i 在打乱后
 * 落到 j 的位置的次数。数组中的所有元素的值都应该接近于 N/M。
 */
public class Ex36 {

    public static void shuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // between i and N-1
            // 选择 i 到 N-1 之间的随机整数 r
            int r = StdRandom.uniformInt(i, N);
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
                // 2023 2046 2008 1985 1938
                // 1953 1936 2015 2017 2079
                // 2000 1978 2048 1999 1975
                // 2020 2021 1979 1974 2006
                // 2004 2019 1950 2025 2002
                System.out.print(num[i][j] + " ");
            }
            System.out.println();
        }
    }

}
