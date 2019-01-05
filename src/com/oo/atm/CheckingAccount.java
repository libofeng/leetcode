package com.oo.atm;

public class CheckingAccount extends Account {
    private String debitCardNumber;

    public String getDebitCardNumber() {
        return debitCardNumber;
    }

    public void setDebitCardNumber(String debitCardNumber) {
        this.debitCardNumber = debitCardNumber;
    }
}
