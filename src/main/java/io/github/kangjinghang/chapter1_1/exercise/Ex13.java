package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 编写一段代码，打印出一个 M 行 N 列的二维数组的转置（交换行和列）。
 */
public class Ex13 {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
        };
        // 1 4
        // 2 5
        // 3 6
        printTransposeMatrix(matrix);
    }

    public static void printTransposeMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // 横向扫描
        for (int i = 0; i < matrix[0].length; i++) {
            // 纵向扫描，遍历所有一维数组，打印该一维数组 i 位置的数值
            for (int j = 0; j < matrix.length; j++) {
                StdOut.printf("%-4d", matrix[j][i]);
            }
            StdOut.println();
        }
    }

}
