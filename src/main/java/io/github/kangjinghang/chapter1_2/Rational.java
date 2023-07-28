package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.StdIn;

/**
 * 有理数。为有理数实现一个不可变数据类型 Rational，支持加减乘除操作。
 * public class Rational
 * Rational(int numerator, int denominator)
 * Rational plus(Rational b) 该数与 b 之和
 * Rational minus(Rational b) 该数与 b 之差
 * Rational times(Rational b) 该数与 b 之积
 * Rational divides(Rational b) 该数与 b 之商
 * boolean equals(Rational that) 该数与 that 相等吗
 * String toString() 对象的字符串表示
 * 无需测试溢出（请见练习 1.2.17），只需使用两个 long 型实例变量表示分子和分母来控制溢出
 * 的可能性。使用欧几里得算法来保证分子和分母没有公因子。编写一个测试用例检测你实现的
 * 所有方法。
 */
public class Rational {

    /**
     * 分子
     */
    private final int numerator;

    /**
     * 分母
     */
    private final int denominator;

    public Rational(int numerator, int denominator) throws ArithmeticException {
        if (denominator == 0) {
            throw new ArithmeticException("Divide by zero");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        // 计算最大公约数
        int commonDivisor = euclid(numerator, denominator);
        this.numerator = numerator / commonDivisor;
        this.denominator = denominator / commonDivisor;
    }

    /**
     * 计算最大公约数
     */
    private int euclid(int p, int q) {
        // p ==0 || q == 0 返回1
        if (p == 0 || q == 0) {
            return 1;
        }
        p = Math.abs(p);
        q = Math.abs(q);
        if (p < q) {
            // p < q，则 p、q 交换
            int t = p;
            p = q;
            q = t;
        }
        if (p % q == 0) {
            // p 是 q 的倍数，直接返回 q
            return q;
        } else {
            return euclid(q, p % q);
        }
    }

    public Rational plus(Rational b) {
        assert !isTimesOverflow(numerator, b.denominator) : "Times overflow";
        assert !isTimesOverflow(b.numerator, denominator) : "Times overflow";
        assert !isPlusOverflow(numerator * b.denominator, b.numerator * denominator) : "Plus overflow";
        assert !isTimesOverflow(denominator, b.denominator) : "Times overflow";
        // 分子 = a分子 * b分母 + b分子 * a分母，分母 = a分母 * b分母
        return new Rational(numerator * b.denominator + b.numerator * denominator, denominator * b.denominator);
    }

    public Rational minus(Rational b) {
        assert !isTimesOverflow(numerator, b.denominator) : "Times overflow";
        assert !isTimesOverflow(b.numerator, denominator) : "Times overflow";
        assert !isPlusOverflow(numerator * b.denominator, -b.numerator * denominator) : "Plus overflow";
        assert !isTimesOverflow(denominator, b.denominator) : "Times overflow";
        // 分子 = a分子 * b分母 - b分子 * a分母，分母 = a分母 * b分母
        return new Rational(numerator * b.denominator - b.numerator * denominator, denominator * b.denominator);
    }

    public Rational times(Rational b) {
        assert !isTimesOverflow(numerator, b.numerator) : "Times overflow";
        assert !isTimesOverflow(denominator, b.denominator) : "Times overflow";
        // 分子 = a分子 * b分子，分母 = a分母 * b分母
        return new Rational(numerator * b.numerator, denominator * b.denominator);
    }

    public Rational divides(Rational b) {
        assert !isTimesOverflow(numerator, b.denominator) : "Times overflow";
        assert !isTimesOverflow(denominator, b.numerator) : "Times overflow";
        // 分子 = a分子 * b分母，分母 = a分母 * b分母
        return new Rational(numerator * b.denominator, denominator * b.numerator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Rational that = (Rational) obj;
        if (this.numerator != that.numerator) {
            return false;
        }
        return this.denominator == that.denominator;
    }

    @Override
    public String toString() {
        if (Math.abs(numerator) % Math.abs(denominator) == 0) {
            return String.valueOf(numerator / denominator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    private boolean isPlusOverflow(int a, int b) {
        return a >= 0 ? b > Integer.MAX_VALUE - a : b < Integer.MIN_VALUE - a;
    }

    private boolean isTimesOverflow(int a, int b) {
        if (a < 0) {
            a = -a;
        }
        if (b < 0) {
            b = -b;
        }
        if (a == 0 || b == 0) {
            return false;
        } else {
            // a * b / b
            return a * b / b != a;
        }
    }

    public static void main(String[] args) {
        System.out.println("Rational a:");
        System.out.print("numerator: ");
        int numerator = StdIn.readInt();
        System.out.print("denominator: ");
        int denominator = StdIn.readInt();
        Rational a = new Rational(numerator, denominator);
        System.out.println("Rational b:");
        System.out.print("numerator: ");
        numerator = StdIn.readInt();
        System.out.print("denominator: ");
        denominator = StdIn.readInt();
        Rational b = new Rational(numerator, denominator);
        System.out.println("a plus b: " + a.plus(b));
        System.out.println("a minus b: " + a.minus(b));
        System.out.println("a times b: " + a.times(b));
        System.out.println("a divides b: " + a.divides(b));
        System.out.println("a equals b: " + a.equals(b));
    }

}
