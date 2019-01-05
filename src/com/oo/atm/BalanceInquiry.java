package com.oo.atm;

public class BalanceInquiry extends Transaction {
    private int accountId;

    public double getAccountId() {
        return 0;
    }

    @Override
    public boolean makeTransaction() {
        return false;
    }
}
