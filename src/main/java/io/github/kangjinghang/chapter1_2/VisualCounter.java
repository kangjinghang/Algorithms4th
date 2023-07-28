package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.StdDraw;

/**
 * 编写一个类 VisualCounter，支持加一和减一操作。它的构造函数接受两个参数 N 和 max，其
 * 中 N 指定了操作的最大次数，max 指定了计数器的最大绝对值。作为副作用，用图像显示每次计
 * 数器变化后的值。
 */
public class VisualCounter {

    /**
     * 操作的最大次数
     */
    private int N;

    /**
     * 计数器的最大绝对值
     */
    private int max;

    /**
     * 计数器的值
     */
    private int count;

    /**
     * 操作的次数
     */
    private int n;

    public VisualCounter(int n, int max) {
        N = n;
        this.max = max;
        count = 0;
        this.n = 0;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(-max, max);
        StdDraw.setPenRadius(0.01);
        StdDraw.point(0, 0);
    }

    public void increment() {
        if (n + 1 > N) {
            System.out.println("Operate too much!");
            return;
        }
        if (count + 1 > max) {
            System.out.println("Exceed the max!");
            return;
        }
        count++;
        n++;
        StdDraw.point(n, count);
    }

    public void decrement() {
        if (n + 1 > N) {
            System.out.println("Operate too much!");
            return;
        }
        if (count - 1 < -max) {
            System.out.println("Exceed the min!");
            return;
        }
        count--;
        n++;
        StdDraw.point(n, count);
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        // 操作的最大次数:20
        // 计数器的最大绝对值:5
        VisualCounter counter = new VisualCounter(20, 5);
        for (int i = 0; i < 10; i++) {
            // 计数器的值 count: 0 -> 5
            // 操作次数 n: 0->5
            counter.increment();
        }
        // 计数器的值 count: 5 -> -5
        // 操作次数 n: 5->15
        for (int i = 0; i < 15; i++) {
            counter.decrement();
        }
        // 计数器的值 count: -5 -> 0
        // 操作次数 n: 15->20
        for (int i = 0; i < 10; i++) {
            counter.increment();
        }
        System.out.println(counter.getCount());
    }

}
