package com.oo.facebook;

public abstract class Account {
    private String id;
    private String password;
    private AccountStatus status;

    public abstract boolean resetPassword();
}
