package com.NewCycle.cashtrash.dtos.response;

import com.NewCycle.cashtrash.model.Wallet;

public record ResponseGetWalletBalance(String walletId, String amount) {
    public static ResponseGetWalletBalance from(Wallet wallet){
        return new ResponseGetWalletBalance(wallet.getId().toString(), wallet.getAmount().toString());
    }
}
