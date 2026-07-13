package com.NewCycle.cashtrash.dtos.response;

import com.NewCycle.cashtrash.model.Wallet;

public record ResponseGetWallet(String idWallet, String amount, String nomeUser, String typeUser,
                                String idUser){

    public static ResponseGetWallet from(Wallet wallet){
        return new ResponseGetWallet(wallet.getId().toString(),
                wallet.getAmount().toString(),wallet.getUser().getName(),
                wallet.getUser().getType().name(),
                wallet.getUser().getId().toString());
    }

}
