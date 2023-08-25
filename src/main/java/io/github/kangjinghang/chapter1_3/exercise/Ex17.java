package io.github.kangjinghang.chapter1_3.exercise;

import io.github.kangjinghang.chapter1_2.Transaction;

import java.util.Arrays;

/**
 * 为 Transaction 类完成练习 1.3.16
 */
public class Ex17 {

    public static void main(String[] args) {
        String s = "Turing 5/22/1939 11.99\nTuring 5/21/1940 12.11";
        Transaction[] transactions = Transaction.readTransactions(s);
        Arrays.stream(transactions).forEach(System.out::println);
    }

}
