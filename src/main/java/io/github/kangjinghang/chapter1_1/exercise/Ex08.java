package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 下列语句会打印出什么结果？给出解释。
 * a. System.out.println('b');
 * b. System.out.println('b' + 'c');
 * c. System.out.println((char) ('a' + 4));
 */
public class Ex08 {

    public static void main(String[] args) {
        // b
        System.out.println('b');
        // 98 + 99 = 197
        System.out.println('b' + 'c');
        // e
        System.out.println((char) ('a' + 4));
    }


}
