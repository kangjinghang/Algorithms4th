package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 给出 exR1(6) 的返回值：
 * public static String exR1(int n)
 * {
 * if (n <= 0) return "";
 * return exR1(n-3) + n + exR1(n-2) + n;
 * }
 */
public class Ex16 {

    public static void main(String[] args) {
        System.out.println(exR1(10));
    }

    // exR1(10) = exR1(7) + 10 exR1(8) +   10 = 114224722531135710225311358311361142246810
    // exR1(9)  = exR1(6) + 9 + exR1(7) +   9 = 311361142246911422472253113579
    // exR1(8)  = exR1(5) + 8 + exR1(6) +   8 = 2253113583113611422468
    // exR1(7)  = exR1(4) + 7 +  exR1(5) +  7 = 1142247225311357
    // exR1(6)  = exR1(3) + 6 + exR1(4) +   6 = 311361142246
    // exR1(5)  = exR1(2) + 5 + exR1(3) +   5 = 22531135
    // exR1(4)  = exR1(1) + 4 + exR1(2) +   4 = 114224
    // exR1(3)  = exR1(0) + 3 + exR1(1) +   3 = 3113
    // exR1(2)  = exR1(-1) + 2 + exR1(0) +  2 = 22
    // exR1(1)  = exR1(-2) + 1 + exR1(-1) + 1 = 11
    // exR1(0)                             = 0
    public static String exR1(int n) {
        if (n <= 0) return "";
        return (exR1(n - 3) + n) + (exR1(n - 2) + n);
    }

}
