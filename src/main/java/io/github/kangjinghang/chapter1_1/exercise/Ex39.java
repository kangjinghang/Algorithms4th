package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * 随机匹配。编写一个使用 BinarySearch 的程序，它从命令行接受一个整型参数 T，并会分别针
 * 对 N=10^3、10^4、10^5 和 10^6 将以下实验运行 T 遍：生成两个大小为 N 的随机 6 位正整数数组并找
 * 出同时存在于两个数组中的整数的数量。打印一个表格，对于每个 N，给出 T 次实验中该数量
 * 的平均值。
 */
public class Ex39 {

    public static void main(String[] args) {
//        if (args.length < 1) {
//            System.out.println("error!");
//            return;
//        }
//        int T = Integer.parseInt(args[0]);
        int T = 100;
        // 10^3、10^4、10^5 和 10^6
        int[] num = new int[4];

        // 将以下实验运行 T 遍
        for (int i = 0; i < T; i++) {
            int N = 100;
            // N 依次为 N=10^3、10^4、10^5 和 10^6
            for (int j = 1; j <= num.length; j++, N *= 10) {
                int[] a = new int[N];
                int[] b = new int[N];
                for (int k = 0; k < N; k++) {
                    // a、b 数组分别初始化
                    a[k] = StdRandom.uniformInt(1000000);
                    b[k] = StdRandom.uniformInt(1000000);
                }

                Arrays.sort(a);

                for (int k = 0; k < N; k++) {
                    if (BinarySearch.indexOf(b, a[k]) != -1) {
                        num[j - 1]++;
                    }
                }
            }
        }

        // 表头
        System.out.println("   N\t Average");
        int N = 100;
        for (int i = 0; i < 4; i++) {
            // N 依次为 N=10^3、10^4、10^5 和 10^6
            N *= 10;
            //     N	    Average
            //    1000      0.00
            //   10000      0.00
            //  100000      0.14
            // 1000000      1.65
            System.out.printf("%7d %9.2f\n", N, (double) num[i] / T);
        }
    }

}
