package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

/**
 * 矩阵库。编写一个 Matrix 库并实现以下 API：
 * public class Matrix
 * static double dot(double[] x, double[] y) 向量点乘
 * static double[][] mult(double[][] a, double[][] b) 矩阵和矩阵之积
 * static double[][] transpose(double[][] a) 转置矩阵
 * static double[] mult(double[][] a, double[] x) 矩阵和向量之积
 * static double[] mult(double[] y, double[][] a) 向量和矩阵之积
 */
public class Ex33 {

    public static void main(String[] args) {
        int h, w;
        // 矩阵长度
        System.out.print("The length of array x: ");
        h = StdIn.readInt();
        double[] x = new double[h];
        for (int i = 0; i < x.length; i++) {
//            x[i] = StdIn.readDouble();
            x[i] = StdRandom.uniformDouble();
        }

        // 矩阵宽度
        System.out.print("The length of array y: ");
        w = StdIn.readInt();
        double[] y = new double[w];
        for (int i = 0; i < y.length; i++) {
//            y[i] = StdIn.readDouble();
            y[i] = StdRandom.uniformDouble();
        }

        // 矩阵a
        System.out.print("The height and width of matrix a: ");
        h = StdIn.readInt();
        w = StdIn.readInt();
        double[][] a = new double[h][w];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
//                a[i][j] = StdIn.readDouble();
                a[i][j] = StdRandom.uniformDouble();
            }
        }

        // 矩阵b
        System.out.print("The height and width of matrix b: ");
        h = StdIn.readInt();
        w = StdIn.readInt();
        double[][] b = new double[h][w];
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
//                b[i][j] = StdIn.readDouble();
                b[i][j] = StdRandom.uniformDouble();
            }
        }
        // 向量点乘
        System.out.println("dot(x, y): " + Matrix.dot(x, y));

        // 矩阵和矩阵之积
        double[][] matrix = Matrix.mult(a, b);
        if (matrix != null) {
            System.out.println("mult(a, b):");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // 转置矩阵
        matrix = Matrix.transpose(a);
        if (matrix != null) {
            System.out.println("transpose(a):");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        // 矩阵和向量之积
        double[] array = Matrix.mult(a, x);
        if (array != null) {
            System.out.println("mult(a, x):");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

        // 向量和矩阵之积
        array = Matrix.mult(y, a);
        if (array != null) {
            System.out.println("mult(y, a):");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }

    }

}
