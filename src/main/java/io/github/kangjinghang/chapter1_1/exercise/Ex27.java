package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 二项分布。估计用以下代码计算 binomial(100, 50, 0.25) 将会产生的递归调用次数：
 * public static double binomial(int N, int k, double p)
 * {
 * if (N == 0 && k == 0) return 1.0;
 * if (N < 0 || k < 0) return 0.0;
 * return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
 * }
 * 将已经计算过的值保存在数组中并给出一个更好的实现。
 */
public class Ex27 {

    private static long COUNT1 = 0;

    private static long COUNT2 = 0;

    /**
     * @param N 总数
     * @param k 预期次数
     * @param p 概率
     */
    public static double binomial(int N, int k, double p) {
        COUNT1++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    public static double bin(int N, int k, double p, double[][] matrix) {
        COUNT2++;
        if (N == 0 && k == 0) {
            return 1.0;
        }
        if (N < 0 || k < 0) {
            return 0.0;
        }
        if (matrix[N][k] == -1) {
            matrix[N][k] = (1.0 - p) * bin(N - 1, k, p, matrix) + p * bin(N - 1, k - 1, p, matrix);
        }
        return matrix[N][k];
    }

    public static double betterBinomial(int N, int k, double p) {
        double[][] matrix = new double[N + 1][k + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= k; j++) {
                matrix[i][j] = -1;
            }
        }
        return bin(N, k, p, matrix);
    }

    public static void main(String[] args) {
        System.out.println(binomial(20, 10, 0.25) + ", COUNT:" + COUNT1);
        System.out.println(betterBinomial(20, 10, 0.25) + ", COUNT:" + COUNT2);
    }

}
