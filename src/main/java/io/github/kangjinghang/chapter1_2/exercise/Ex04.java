package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 以下这段代码会打印出什么？
 * String string1 = "hello";
 * String string2 = string1;
 * string1 = "world";
 * StdOut.println(string1);
 * StdOut.println(string2);
 */
public class Ex04 {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        // world
        StdOut.println(string1);
        // hello
        StdOut.println(string2);
    }

}
