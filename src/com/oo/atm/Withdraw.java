package com.oo.atm;

public class Withdraw extends Transaction {
    private double amount;

    @Override
    public boolean makeTransaction() {
        return false;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
