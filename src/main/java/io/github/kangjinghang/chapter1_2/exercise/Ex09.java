package io.github.kangjinghang.chapter1_2.exercise;

import edu.princeton.cs.algs4.Counter;

/**
 * 修改 BinarySearch（请见 1.1.10.1 节中的二分查找代码），使用 Counter 统计在有查找中被检
 * 查的键的总数并在查找全部结束后打印该值。提示：在 main() 中创建一个 Counter 对象并将它
 * 作为参数传递给 rank()。
 */
public class Ex09 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 6, 7, 8, 9, 12};
        int key = 6;
        final Counter counter = new Counter("keys searched");
        int pos = rank(a, key, counter);
        if (pos == -1) {
            System.out.println("not found!");
        } else {
            System.out.println("position=" + pos);
        }
        System.out.println(counter);
    }

    public static int rank(int[] a, int key, Counter counter) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            counter.increment();
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
