package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 编写一个递归的静态方法计算 ln(N!) 的值。
 */
public class Ex20 {

    public static double ln(int n) {
        // 数学原理：ln(N*M) = ln(N) + ln(M)
        if (n == 0) {
            return 0;
        }
        return Math.log(n) + ln(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(ln(10));
    }

}
