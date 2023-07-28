package io.github.kangjinghang.chapter1_2;

import java.util.Arrays;

public class StaticSETofInts {

    private int[] a;

    public StaticSETofInts(int[] keys) {
        this.a = new int[keys.length];
        // 保护性复制
        System.arraycopy(keys, 0, a, 0, keys.length);
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // 键要么存在于 a[lo..hi] 中，要么不存在
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
