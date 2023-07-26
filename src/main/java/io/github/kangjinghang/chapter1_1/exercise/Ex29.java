package io.github.kangjinghang.chapter1_1.exercise;

import java.util.Arrays;

/**
 * 等值键。为 BinarySearch 类添加一个静态方法 rank()，它接受一个键和一个整型有序数组（可
 * 能存在重复键）作为参数并返回数组中小于该键的元素数量，以及一个类似的方法 count() 来
 * 返回数组中等于该键的元素的数量。注意：如果 i 和 j 分别是 rank(key,a) 和 count(key,a)
 * 的返回值，那么 a[i..i+j-1] 就是数组中所有和 key 相等的元素。
 */
public class Ex29 {

    public static int rank(int key, int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            if (key == arr[i]) {
//                return i;
//            }
//        }
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) {
                hi = mid - 1;
            } else if (key > arr[mid]) {
                lo = mid + 1;
            } else {
                while (mid > 0 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            }
        }
        return -1;
    }

    public static int count(int key, int[] arr) {
        int count = 0;
        int pos = rank(key, arr);
        if (pos == -1) {
            return count;
        }
        for (int i = pos; i < arr.length && key == arr[i]; i++) {
            if (key == arr[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] whitelist = {1, 1, 1, 5, 5, 5, 7, 7, 7, 9, 9, 9};
        System.out.println(Arrays.toString(whitelist));
        final int key = 9;
        System.out.println(rank(key, whitelist));

        System.out.println(count(key, whitelist));
    }

}
