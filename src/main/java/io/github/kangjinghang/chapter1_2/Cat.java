package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

/**
 * 使用了多个输入流来将多个输入文件归并到同一个输出文件中
 */
public class Cat {

    // java-algs4 Cat.java in1.txt in2.txt out.txt
    public static void main(String[] args) {
        // 将所有输入文件复制到输出流（最后一个参数）中
        Out out = new Out(args[args.length - 1]);
        for (int i = 0; i < args.length - 1; i++) {
            In in = new In(args[i]);
            String s = in.readAll();
            out.println(s);
            in.close();
        }
        out.close();
    }

}
