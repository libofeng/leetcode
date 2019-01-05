package com.oo.atm;

public class Bank {
    private String name;
    private String backCode;

    public boolean addATM(ATM atm){
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackCode() {
        return backCode;
    }

    public void setBackCode(String backCode) {
        this.backCode = backCode;
    }
}
