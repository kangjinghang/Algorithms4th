package io.github.kangjinghang.chapter1_2;

import edu.princeton.cs.algs4.Date;

public class Transaction {

    /**
     * customer
     */
    private String who;

    /**
     * date
     */
    private Date when;

    /**
     * amount
     */
    private double amount;

    public Transaction(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    /**
     * Exercise 1.2.19
     */
    public Transaction(String transaction) {
        String[] fields = transaction.split("\\s+");
        who = fields[0];
        when = new Date(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Exercise 1.2.14
     */
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
        Transaction that = (Transaction) obj;
        if (!this.who.equals(that.who)) {
            return false;
        }
        if (!this.when.equals(that.when)) {
            return false;
        }
        return this.amount == that.amount;
    }

    public static void main(String[] args) {
        Transaction transaction1 = new Transaction("Turing", new Date(5, 22, 1939), 11.99);
        Transaction transaction2 = new Transaction("Turing 5/22/1939 11.99");
        System.out.println(transaction1.equals(transaction2));
    }

}
