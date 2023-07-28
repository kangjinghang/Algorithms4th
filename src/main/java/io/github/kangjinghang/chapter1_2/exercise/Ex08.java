package io.github.kangjinghang.chapter1_2.exercise;

/**
 * 设 a[] 和 b[] 均为长数百万的整形数组。以下代码的作用是什么？有效吗？
 * int[] t = a; a = b; b = t;
 * 答：这段代码会将它们交换。它的效率不可能再高了，因为它复制的是引用而不需要复制数百万个元素。
 */
public class Ex08 {

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[10];
        // 这段代码会将它们交换。它的效率不可能再高了，因为它复制的是引用而不需要复制数百万个元素。
        int[] t = a;
        a = b;
        b = t;
    }

}
