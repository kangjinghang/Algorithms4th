package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.In;

/**
 * 文件输入。基于 String 的 split() 方法实现 In 中的静态方法 readInts()。
 * 解答：
 * public static int[] readInts(String name)
 * {
 * In in = new In(name);
 * String input = in.readAll();
 * String[] words = input.split("\\s+");
 * int[] ints = new int[words.length];
 * for(int i = 0; i < word.length; i++)
 * ints[i] = Integer.parseInt(words[i]);
 * return ints;
 * }
 * 我们会在 1.3 节中学习另一个不同的实现（请见 1.3.1.5 节）。
 */
public class Ex15 {

    public static void main(String[] args) {
        int[] ints = readInts(args[0]);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] readInts(String name) {
        In in = new In(name);
        String input = in.readAll();
        // 空白字符分割
        String[] words = input.split("\\s+");
        int[] ints = new int[words.length];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(words[i]);
        }
        return ints;
    }

}
