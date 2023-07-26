package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 给出以下表达式的值：
 * a. ( 0 + 15 ) / 2
 * b. 2.0e-6 * 100000000.1
 * c. true && false || true && true
 */
public class Ex01 {

    public static void main(String[] args) {
        // 7
        System.out.println((0 + 15) / 2);
        // 200.0000002
        System.out.println(2.0e-6 * 100000000.1);
        // true
        System.out.println(true && false || true && true);
    }

}
