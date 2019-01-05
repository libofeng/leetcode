package com.oo.atm;

public class Screen {
    public boolean showMessage(String message){
        return true;
    }

    public TransactionType getInput(){
        return new TransactionType();
    }
}
