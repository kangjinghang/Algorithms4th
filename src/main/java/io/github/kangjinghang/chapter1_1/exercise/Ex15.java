package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 编写一个静态方法 histogram()，接受一个整型数组 a[] 和一个整数 M 为参数并返回一个大小
 * 为M的数组，其中第i个元素的值为整数i在参数数组中出现的次数。如果a[]中的值均在0到M-1
 * 之间，返回数组中所有元素之和应该和 a.length 相等。
 */
public class Ex15 {

    public static void main(String[] args) {
        // a.length = 4
        int[] a = {0, 2, 1, 1};
        int M = 3;
        // histogram = {1,2,1}
        int[] histogram = histogram(a, M);
        int sum = 0;
        for (int i : histogram) {
            sum += i;
        }
        System.out.println(sum == a.length);

        histogram = histogram2(a, M);
        sum = 0;
        for (int i : histogram) {
            sum += i;
        }
        System.out.println(sum == a.length);
    }

    /**
     * a 数组中所有元素的值均在[0,M-1]
     */
    public static int[] histogram(int[] a, int M) {
        int[] result = new int[M];
        for (int i = 0; i < M; i++) {
            int val = 0;
            for (int j : a) {
                if (a[i] >= 0 && a[i] < M && i == j) {
                    val++;
                }
            }
            result[i] = val;
        }
        return result;
    }

    public static int[] histogram2(int[] a, int M) {
        int[] result = new int[M];
        for (int i : a) {
            // 校验数值有效性
            if (i >= 0 && i < M) {
                // i = 值
                // 值计数+1
                result[i]++;
            }
        }
        return result;
    }

}
