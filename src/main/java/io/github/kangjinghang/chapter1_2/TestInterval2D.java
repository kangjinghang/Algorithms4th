package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.*;

/**
 * Interval2D 的测试用例
 */
public class TestInterval2D {

    public static void main(String[] args) {
//        double xlo = Double.parseDouble(args[0]);
        double xlo = 0.2;
//        double xhi = Double.parseDouble(args[1]);
        double xhi = 0.5;
//        double ylo = Double.parseDouble(args[2]);
        double ylo = 0.5;
//        double yhi = Double.parseDouble(args[3]);
        double yhi = 0.6;
//        int T = Integer.parseInt(args[4]);
        int T = 100000;
        // 直线上间隔，矩形的长
        Interval1D xinterval = new Interval1D(xlo, xhi);
        // 直线上间隔，矩形的宽
        Interval1D yinterval = new Interval1D(ylo, yhi);
        // 矩形
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();
        Counter c = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = Math.random();
            double y = Math.random();
            Point2D p = new Point2D(x, y);
            if (box.contains(p)) c.increment();
            else p.draw();
        }
        StdOut.println(c);
        StdOut.println(box.area());
        // 3042 hits
        // 0.029999999999999992
    }

}
