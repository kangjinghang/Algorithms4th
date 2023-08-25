package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_2.BasicDate;

import java.util.Arrays;

/**
 * 使用 1.3.1.5 节中的 readInts() 作为模板为 Date 编写一个静态方法 readDates()，从标准输入
 * 中读取由练习 1.2.19 的表格所指定的格式的多个日期并返回一个它们的数组。
 */
public class Ex16 {

    public static void main(String[] args) {
        String s = "11/30/2009 1/12/2012";
        BasicDate[] dates = BasicDate.readDates(s);
        Arrays.stream(dates).forEach(System.out::println);
    }

}
