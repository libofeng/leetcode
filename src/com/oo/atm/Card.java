package com.oo.atm;

import java.util.Date;

public class Card {
    private String cardNumber;
    private String customerName;
    private Date cardExpired;
    private int pin;

    public Address getBillingAdress() {
        return new Address();
    }
}
