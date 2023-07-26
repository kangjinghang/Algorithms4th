package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 暴力查找
 */
public class BruteForceSearch {

    public static int rank(int key, int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) {
                return i;
            }
        }
        return -1;
    }
}
