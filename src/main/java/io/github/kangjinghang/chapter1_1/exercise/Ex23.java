package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdIn;

/**
 * 为 BinarySearch 的测试用例添加一个参数：+ 打印出标准输入中不在白名单上的值；-，则打
 * 印出标准输入中在白名单上的值。
 */
public class Ex23 {

    private static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
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

    public static void main(String[] args) {
        int[] whitelist = {1, 2, 3, 4, 6, 7, 8, 9, 12};
        System.out.printf("+ or - ? \n");
        char flag = StdIn.readChar();
        StdIn.readLine();
        System.out.printf("Input data keys: \n");
        String[] keys = StdIn.readLine().split(" ");
        if (flag == '+') {
            System.out.println("不在白名单上的值：");
        } else if (flag == '-') {
            System.out.println("在白名单上的值：");
        }
        for (int i = 0; i < keys.length; i++) {
            if (rank(Integer.parseInt(keys[i]), whitelist) != -1 && flag == '-') {
                System.out.printf("%s ", keys[i]);
            } else if (rank(Integer.parseInt(keys[i]), whitelist) == -1 && flag == '+') {
                System.out.printf("%s ", keys[i]);
            }
        }
        System.out.println();
    }

}
