package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * 二分查找与暴力查找。根据 1.1.10.4 节给出的暴力查找法编写一个程序 BruteForceSearch，在你
 * 的计算机上比较它和 BinarySearch 处理 largeW.txt 和 largeT.txt 所需的时间。
 */
public class Ex38 {

    // java-algs4 Ex38.java /Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/largeW.txt
    public static void main(String[] args) {
//        final String resource = args[0];
        final String whitelistPath = "/Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/largeW.txt";
        int[] whitelist = new In(whitelistPath).readAllInts();

        String keyPath = "/Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/largeT.txt";
        int[] keyList = new In(keyPath).readAllInts();

        bruteForceSearch(whitelist, keyList);
        binarySearch(whitelist, keyList);
    }

    private static void binarySearch(int[] whitelist, int[] keyList) {
        long startTime = System.currentTimeMillis();
        Arrays.sort(whitelist);
        for (int key : keyList) {
            if (BinarySearch.indexOf(whitelist, key) == -1) {
//                StdOut.println(key);
            }
        }
        long endTime = System.currentTimeMillis();
        // Binary search time: 360
        System.out.println("Binary search time: " + (endTime - startTime));
    }

    private static void bruteForceSearch(int[] whitelist, int[] keyList) {
        long startTime = System.currentTimeMillis();
        for (int key : keyList) {
            if (BruteForceSearch.rank(key, whitelist) == -1) {
//                StdOut.println(key);
            }
        }
        long endTime = System.currentTimeMillis();
        // Brute force search time: 139468
        System.out.println("Brute force search time: " + (endTime - startTime));
    }

}
