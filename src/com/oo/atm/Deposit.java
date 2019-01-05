package com.oo.atm;

public abstract class Deposit extends Transaction {
    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
