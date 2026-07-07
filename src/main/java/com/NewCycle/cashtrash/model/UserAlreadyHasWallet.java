package com.NewCycle.cashtrash.model;

public class UserAlreadyHasWallet extends RuntimeException {
    public UserAlreadyHasWallet(Long id) {
        super("user with id: "+id+" has wallet");
    }
}
