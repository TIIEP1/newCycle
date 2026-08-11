package com.NewCycle.cashtrash.model.exception;

public class WalletNotFoundException extends RuntimeException {
    public WalletNotFoundException(Long walletId) {
        super("wallet with id: "+walletId+" not found");
    }
}
