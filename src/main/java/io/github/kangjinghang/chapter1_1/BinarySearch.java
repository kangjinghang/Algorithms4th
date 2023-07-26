package io.github.kangjinghang.chapter1_1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * BinarySearch
 * <p>
 * 编译
 * pwd：/Users/kangjinghang/workspace/github/Algorithms4th/src/main/java/io/github/kangjinghang/chapter1_1
 * <p>
 * 执行
 * jdk8：
 * pwd：/Users/kangjinghang/workspace/github/Algorithms4th/src/main/java
 * java-algs4 io.github.kangjinghang.chapter1_1.BinarySearch
 * <p>
 * jdk11： 单个文件可以直接执行
 * pwd：/Users/kangjinghang/workspace/github/Algorithms4th/src/main/java
 * java-algs4 BinarySearch.java
 */
public class BinarySearch {

    public static int rank(int key, int[] arr) {
        // 数组必须是有序的
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            // 被查找的键要么不存在，要么必然存在于 a[lo..hi] 之中
            int mid = (lo + hi) / 2;
            if (arr[mid] < key) {
                lo = mid + 1;
            } else if (arr[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int recursivelyRank(int key, int[] arr) {
        return recursivelyRank(key, arr, 0, arr.length - 1);
    }

    public static int recursivelyRank(int key, int[] arr, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid]) {
            return recursivelyRank(key, arr, 0, mid - 1);
        } else if (key > arr[mid]) {
            return recursivelyRank(key, arr, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public static int recursivelyRankAndTrace(int key, int[] arr) {
        return recursivelyRankAndTrace(key, arr, 0, arr.length - 1, 0);
    }

    public static int recursivelyRankAndTrace(int key, int[] arr, int lo, int hi, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.printf("  ");
        }
        System.out.println("lo=" + lo + ", hi=" + hi);
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid]) {
            return recursivelyRankAndTrace(key, arr, 0, mid - 1, depth + 1);
        } else if (key > arr[mid]) {
            return recursivelyRankAndTrace(key, arr, mid + 1, hi, depth + 1);
        } else {
            return mid;
        }
    }


    // java-algs4 BinarySearch.java /Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/largeW.txt < /Users/kangjinghang/workspace/github/Algorithms4th/src/main/resources/introcs-data/largeT.txt
    public static void main(String[] args) {
        // case1:
//        final double gaussian = StdRandom.gaussian();
//        System.out.println("gaussian = " + gaussian);
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            // 读取键值，如果不存在于白名单中则将其打印
            int key = StdIn.readInt();
            if (recursivelyRank(key, whitelist) != -1) {
                StdOut.println(key);
            }
        }

        // case2:
        int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};
        int key = 5;
        int pos = recursivelyRankAndTrace(key, a);
        if (pos == -1) {
            System.out.println("not found!");
        } else {
            System.out.println("position=" + pos);
        }
    }

}
