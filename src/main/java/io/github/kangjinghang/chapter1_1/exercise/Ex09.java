package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 编写一段代码，将一个正整数 N 用二进制表示并转换为一个 String 类型的值 s。
 * 解答：Java 有一个内置方法 Integer.toBinaryString(N) 专门完成这个任务，但该题的目的就
 * 是给出这个方法的其他实现方法。下面就是一个特别简洁的答案：
 * String s = "";
 * for (int n = N; n > 0; n /= 2)
 * s = (n % 2) + s;
 */
public class Ex09 {

    public static void main(String[] args) {
        // 110
        int N = 6;
        String s = toBinaryString(N);
        System.out.println(s);
        s = toBinaryString2(N);
        System.out.println(s);
    }

    private static String toBinaryString(int value) {
        if (value == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = value; i > 0; i /= 2) {
            // 头插法
            sb.insert(0, (i % 2));
        }
        return sb.toString();
    }

    private static String toBinaryString2(int value) {
        int buffLen = 32;
        int index = buffLen;
        char[] result = new char[buffLen];
        do {
            result[--index] = (char) ('0' + (value & 1));
            value = value >>> 1;
        } while (value != 0);
        return new String(result, index, buffLen - index);
    }

}
