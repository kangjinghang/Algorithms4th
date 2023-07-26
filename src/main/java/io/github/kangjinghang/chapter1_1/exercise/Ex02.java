package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 给出以下表达式的类型和值：
 * a. (1 + 2.236)/2
 * b. 1 + 2 + 3 + 4.0
 * c. 4.1 >= 4
 * d. 1 + 2 + "3"
 */
public class Ex02 {

    public static void main(String[] args) {
        // 1.618
        System.out.println((1 + 2.236) / 2);
        // 10.0
        System.out.println(1 + 2 + 3 + 4.0);
        // true
        System.out.println(4.1 >= 4);
        // 33
        System.out.println(1 + 2 + "3");
    }

}
