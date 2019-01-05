package com.oo.atm;

public class Transfer extends Transaction {
    private int destinationAccountNumber;

    @Override
    public boolean makeTransaction() {
        return false;
    }

    public int getDestinationAccountNumber() {
        return destinationAccountNumber;
    }

    public void setDestinationAccountNumber(int destinationAccountNumber) {
        this.destinationAccountNumber = destinationAccountNumber;
    }
}
