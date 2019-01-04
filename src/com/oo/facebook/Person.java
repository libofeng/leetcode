package com.oo.facebook;

public class Person extends Account {
    private String name;
    private Address address;
    private String email;
    private String phone;

    private Account account;

    @Override
    public boolean resetPassword() {
        return false;
    }
}
