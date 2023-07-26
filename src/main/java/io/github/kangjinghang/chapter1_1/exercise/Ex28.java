package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 删除重复元素。修改 BinarySearch 类中的测试用例来删去排序之后白名单中的所有重复元素。
 */
public class Ex28 {

    public static void main(String[] args) {
        int[] whitelist = {7, 1, 5, 1, 9, 9, 9, 5, 7, 7, 5, 1};
        Arrays.sort(whitelist);

        ArrayList<Integer> uniqueList = new ArrayList<>();
        for (int i = 0; i < whitelist.length - 1; i++) {
            // 前一位 != 后一位，加入前一位
            if (whitelist[i] != whitelist[i + 1]) {
                uniqueList.add(whitelist[i]);
            }
        }
        // 最后一位单独加入
        uniqueList.add(whitelist[whitelist.length - 1]);

        // 重建 whitelist 数组
        whitelist = new int[uniqueList.size()];
        for (int i = 0; i < whitelist.length; i++) {
            whitelist[i] = uniqueList.get(i);
            System.out.print(whitelist[i] + " ");
        }
        System.out.println();
        System.out.println(BinarySearch.indexOf(whitelist, StdIn.readInt()));
    }

}
