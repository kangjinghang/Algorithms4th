package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 数组练习。编写一段程序，创建一个 N×N 的布尔数组 a[][]。其中当 i 和 j 互质时（没有相同
 * 因子），a[i][j] 为 true，否则为 false。
 */
public class Ex30 {

    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    public static void main(String[] args) {
        int N = 10;
        boolean[][] matrix = new boolean[N][N];
//        System.out.println(gcd(3,5));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (gcd(i, j) == 1);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrix[i][j] ? "T" : "F");
                System.out.print("\t");
            }
            System.out.println();
        }
    }

}
