package com.oo.atm;

public class CashDeposit extends Deposit {
    private double cashDepositLimit;

    public double getCashDepositLimit() {
        return cashDepositLimit;
    }

    public void setCashDepositLimit(double cashDepositLimit) {
        this.cashDepositLimit = cashDepositLimit;
    }

    @Override
    public boolean makeTransaction() {
        return false;
    }
}
