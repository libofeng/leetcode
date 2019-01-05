package com.oo.atm;

public class SavingAccount extends Account {
    private double withdrawLimit;

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
