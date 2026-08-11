package com.NewCycle.cashtrash.model.exception;

public class UserAlreadyHasWallet extends RuntimeException {
    public UserAlreadyHasWallet(Long id) {
        super("user with id: "+id+" has wallet");
    }
}
