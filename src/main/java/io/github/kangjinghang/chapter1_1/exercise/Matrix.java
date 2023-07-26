package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 矩阵库。编写一个 Matrix 库并实现以下 API：
 * public class Matrix
 * static double dot(double[] x, double[] y) 向量点乘
 * static double[][] mult(double[][] a, double[][] b) 矩阵和矩阵之积
 * static double[][] transpose(double[][] a) 转置矩阵
 * static double[] mult(double[][] a, double[] x) 矩阵和向量之积
 * static double[] mult(double[] y, double[][] a) 向量和矩阵之积
 */
public class Matrix {

    /**
     * 向量点乘
     */
    static double dot(double[] x, double[] y) {
        double result = 0;
        if (x.length != y.length) {
            System.err.println("Error!");
            return result;
        }
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    /**
     * 矩阵和矩阵之积
     */
    static double[][] mult(double[][] a, double[][] b) {
        /*
         * 矩阵a：
         * 2 3
         * 4 5
         * 5 6
         *
         * 矩阵b：
         * 1 2 3
         * 3 4 5
         *
         */
        // a 的列数 == b 的行数的时候才有意义
        if (a[0].length == b.length) {
            // s 的行数 = a 的行数，s 的列数 = b 的列数
            // 3行3列，矩阵a定行数，矩阵b定列数
            double[][] s = new double[a.length][b[0].length];
            for (int i = 0; i < s.length; i++) { // 3行
                for (int j = 0; j < s[i].length; j++) { // 3列
                    for (int k = 0; k < b.length; k++) {
                        // s[i][j] 值 = 矩阵a的第i行的元素与矩阵b的第j列对应元素乘积之和
                        // a 的行向量*b的列向量
                        s[i][j] += a[i][k] * b[k][j];
                    }
                }
            }
            return s;
        } else {
            System.err.println("Error!");
            return null;
        }
    }

    /**
     * 转置矩阵
     */
    static double[][] transpose(double[][] a) {
        // a 3行2列 a = double[3][2]
        // a[0].length：列数
        double[][] s = new double[a[0].length][a.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length; j++) {
                s[i][j] = a[j][i];
            }
        }
        return s;
    }

    /**
     * 矩阵和向量之积。既可以看作矩阵的行向量与向量的点积，又可以看作矩阵的列向量的加权和(或线性组合)
     */
    static double[] mult(double[][] a, double[] x) {
        // a m行n列
        // x 长度=n列，是水平的，单行
        if (a[0].length == x.length) {
            // a.length = y.length，m行
            double[] y = new double[a.length]; // 乘积 y 长度 = a m行
            // a[i][0]*x[0]+a[i][1]*x[1]+...+a[i][j]*x[j]
            for (int i = 0; i < y.length; i++) { // m行，i 行号
                for (int j = 0; j < x.length; j++) { // n列，j 列号
                    // 矩阵的行向量与向量的点积
                    // y第i行 = 矩阵a第i行第j个元素 * 向量x第j个元素
                    y[i] += a[i][j] * x[j]; // 按 行 汇总 当前行 所有 列 的合计，x[j]当作 第 j 列 权重既可，y[i]是 当前行 权重合计
                }
            }
            return y;
        } else {
            System.err.println("Error!");
            return null;
        }
    }

    /**
     * 向量和矩阵之积
     */
    static double[] mult(double[] y, double[][] a) {
        // a m行n列
        // y 长度=m行
        if (a.length == y.length) {
            // a[0].length = x.length，n列
            double[] x = new double[a[0].length]; // 乘积 x 长度 = a n列，水平方向
            for (int i = 0; i < x.length; i++) { // n列，i 列号
                for (int j = 0; j < y.length; j++) { // m行，j 行号
                    x[i] += y[j] * a[j][i]; // 按 列 汇总 当前列 所有 行 的合计，y[j]当作 第 i 行 权重既可，x[i]是 当前列 权重合计
                }
            }
            return x;
        } else {
            System.err.println("Error!");
            return null;
        }
    }

}
