package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.StdOut;
import io.github.kangjinghang.chapter1_3.Queue;

public class BasicDate {

    private final int month;
    private final int day;
    private final int year;

    public BasicDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public BasicDate(String date) {
        String[] s = date.split("\\/");
        if (s.length != 3) {
            throw new IllegalArgumentException("Arguments illegal: " + date);
        }
        month = Integer.parseInt(s[0]);
        day = Integer.parseInt(s[1]);
        year = Integer.parseInt(s[2]);
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    public String toString() {
        return month() + "/" + day()
                + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        BasicDate that = (BasicDate) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        return this.year == that.year;
    }

    public static BasicDate[] readDates(String s) {
        String[] dates = s.split(" ");
        int n = dates.length;
        Queue<BasicDate> q = new Queue<>();
        for (String date : dates) {
            q.enqueue(new BasicDate(date));
        }
        BasicDate[] result = new BasicDate[n];
        for (int i = 0; i < n; i++) {
            result[i] = q.dequeue();
        }
        return result;
    }

    // java-algs4 BasicDate.java 12 31 2023
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        int y = Integer.parseInt(args[2]);
        BasicDate date = new BasicDate(m, d, y);
        // 12/31/2023
        StdOut.println(date);
    }

}