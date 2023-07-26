package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段程序，从标准输入按行读取数据，其中每行都包含一个名字和两个整数。然后用
 * printf() 打印一张表格，每行的若干列数据包括名字、两个整数和第一个整数除以第二个整数
 * 的结果，精确到小数点后三位。可以用这种程序将棒球球手的击球命中率或者学生的考试分数
 * 制成表格。
 *
 * <p>
 * Please input count:3
 * kang 1 3
 * jing 4 7
 * hang 5 10
 * input ok, prepare print table:
 * |  kang|   1|   3| 0.333|
 * +------+----+----+------+
 * |  jing|   4|   7| 0.571|
 * +------+----+----+------+
 * |  hang|   5|  10| 0.500|
 */
public class Ex21 {

    public static void main(String[] args) {
        System.out.print("Please input count:");
        int n = StdIn.readInt();
        String[] nameArray = new String[n];
        int[] integerArray1 = new int[n];
        int[] integerArray2 = new int[n];
        for (int i = 0; i < n; i++) {
            nameArray[i] = StdIn.readString();
            integerArray1[i] = StdIn.readInt();
            integerArray2[i] = StdIn.readInt();
        }

        System.out.println("input ok, prepare print table:");
        for (int i = 0; i < n; i++) {
            StdOut.printf("|%6s|%4d|%4d|%6.3f|\n", nameArray[i], integerArray1[i], integerArray2[i],
                    (float) integerArray1[i] / integerArray2[i]);
            if (i != n - 1) {
                System.out.println("+------+----+----+------+");
            }
        }

    }

}
