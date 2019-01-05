package com.oo.atm;

public class CheckDeposit extends Deposit {
    private String checkNumber;
    private String bankCode;

    @Override
    public boolean makeTransaction() {
        return false;
    }
}
