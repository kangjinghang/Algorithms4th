package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段代码，打印出一个二维布尔数组的内容。其中，使用 * 表示真，空格表示假。打印出
 * 行号和列号。
 */
public class Ex11 {

    public static void main(String[] args) {
        boolean[][] a = {
                {true, false, true},
                {false, true, false},
                {true, true, false}
        };
        printBooleanMatrix(a);
    }

    public static void printBooleanMatrix(boolean[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            final boolean[] arr = matrix[i];
            for (int j = 0; j < arr.length; j++) {
                if (matrix[i][j]) {
                    StdOut.print(" * \t");
                } else {
                    StdOut.print(i + "-" + j + "\t");
                }
            }
            StdOut.println();
        }
    }

}
