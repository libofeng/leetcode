package com.oo.atm;

public class ATM {
    private int atmId;
    private Address address;

    private CashDispenser cashDispenser;
    private Keypad keypad;
    private Screen screen;
    private Printer printer;
    private CheckDepositSlot checkDeposit;
    private CashDepositSlot cashDeposite;

    public boolean authenticateUser(){
        return true;
    }

    public boolean makeTransaction(Customer customer, Transaction transaction) {
        return true;
    }
}
