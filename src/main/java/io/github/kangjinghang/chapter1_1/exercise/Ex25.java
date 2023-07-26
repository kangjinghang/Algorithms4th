package io.github.kangjinghang.chapter1_1.exercise;

import edu.princeton.cs.algs4.StdOut;

/**
 * 使用数学归纳法证明欧几里得算法能够计算任意一对非负整数 p 和 q 的最大公约数。
 * <p>
 * 证明：
 * k,r为整数，设r = a mod b，则a可以表示成a=k*b+r。
 * 假设d是{a,b}的一个公约数，则d整除a，d整除b。而r=a-k*b，因此d也整除r，那么，d也是b和r的公约数。
 * 假设d是{b,r}的一个公约数，则d整除b，d整除r。而a=k*b+r，因此d也整除a，那么，d也是a和b的公约数。
 * 因此{a,b}和{b,r}的公因子集合是一样的。特别地，{a,b}的最大公因子和{b,r}的最大公因子是一样的，即gcd(a,b)=gcd(b,a mod b)。
 */
public class Ex25 {

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
