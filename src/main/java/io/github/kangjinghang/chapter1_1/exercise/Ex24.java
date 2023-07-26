package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 给出使用欧几里得算法计算 105 和 24 的最大公约数的过程中得到的一系列 p 和 q 的值。扩展该
 * 算法中的代码得到一个程序 Euclid，从命令行接受两个参数，计算它们的最大公约数并打印出每
 * 次调用递归方法时的两个参数。使用你的程序计算 1 111 111 和 1 234 567 的最大公约数。
 *
 * <p>
 * 证明：
 * k,r为整数，设r = a mod b,则a可以表示成a=kb+r。
 * 假设d是{a,b}的一个公约数，则d整除a,d整除b，而r=a-kb，因此d整除r，d也是b和r的公约数。
 * 假设d是{b,r}的一个公约数，则d整除b,d整除r，而a=kb+r，因此d整除a, d也是a和b的公约数。
 * 因此{a,b}和{b,r}的公因子集合是一样的。特别地，{a,b}的最大共因子和{b,r}的最大公因子是一样的，即gcd(a,b)=gcd(b,a mod b)。
 */
public class Ex24 {

    /**
     * @param p 较大值
     * @param q 较小值
     * @return 最大公约数
     */
    private static int gcd(int p, int q) {
        StdOut.printf("p = %s, q = %s\n", p, q);
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    private static int simplyGcd(int p, int q) {
        return q == 0 ? p : simplyGcd(q, p % q);
    }

    public static void main(String[] args) {
        final int p = 105;
        final int q = 24;
        final int result = simplyGcd(q, p);
        System.out.println("result = " + result);
    }

}
