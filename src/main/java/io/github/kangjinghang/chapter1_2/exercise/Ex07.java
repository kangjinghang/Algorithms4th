package io.github.kangjinghang.chapter1_2.exercise;

/**
 * 以下递归函数的返回值是什么？
 * public static String mystery(String s)
 * {
 * int N = s.length();
 * if (N <= 1) return s;
 * String a = s.substring(0, N/2);
 * String b = s.substring(N/2, N);
 * return mystery(b) + mystery(a);
 * }
 */
public class Ex07 {

    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s = "abcde";
        // edcba
        System.out.println(mystery(s));
    }

}
