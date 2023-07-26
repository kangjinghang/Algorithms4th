package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 请看以下递归函数：
 * public static int mystery(int a, int b)
 * {
 * if (b == 0) return 0;
 * if (b % 2 == 0) return mystery(a+a, b/2);
 * return mystery(a+a, b/2) + a;
 * }
 */
public class Ex18 {

    public static void main(String[] args) {
        System.out.println(mystery(2, 25));
        System.out.println(mystery(3, 11));
    }

    public static int mystery(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            // b 是偶数，
            return mystery(a + a, b / 2);
        }
        // b 是奇数
        return mystery(a + a, b / 2) + a;
    }

    public static int mystery2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery2(a * a, b / 2);
        }
        return mystery2(a * a, b / 2) * a;
    }

}
