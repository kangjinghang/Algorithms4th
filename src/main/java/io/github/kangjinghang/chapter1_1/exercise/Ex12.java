package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 以下代码段会打印出什么结果？
 * int[] a = new int[10];
 * for (int i = 0; i < 10; i++)
 * a[i] = 9 - i;
 * for (int i = 0; i < 10; i++)
 * a[i] = a[a[i]];
 * for (int i = 0; i < 10; i++)
 * System.out.println(i);
 */
public class Ex12 {

    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            //index 0 1 2 3 4 5 6 7 8 9
            // a = {9,8,7,6,5,4,3,2,1,0}
            a[i] = 9 - i;
        for (int i = 0; i < 10; i++)
            // a = {0,1,2,3,4,4,3,2,1,0}
            a[i] = a[a[i]];
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + "\t");
    }

}
