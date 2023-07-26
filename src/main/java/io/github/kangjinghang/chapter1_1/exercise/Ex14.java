package io.github.kangjinghang.chapter1_1.exercise;

/**
 * 编写一个静态方法 lg()，接受一个整型参数 N，返回不大于 log2N 的最大整数。不要使用 Math 库。
 */
public class Ex14 {

    public static void main(String[] args) {
        int value = 1025;
        System.out.printf("the result of method log is :%s\r\n", lg(value));
    }

    public static int lg(int n) {
        int shiftRightCount = 0;
        do {
            // 每次除2
            n >>>= 1;
            shiftRightCount++;
        } while (n != 0);
        return shiftRightCount - 1;
    }

}
