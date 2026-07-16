package com.NewCycle.cashtrash.model;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(Long walletId) {
        super("wallet with id: "+walletId+" not found");
    }
}
