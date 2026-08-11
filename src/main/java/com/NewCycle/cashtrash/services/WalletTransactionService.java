package com.NewCycle.cashtrash.services;

import com.NewCycle.cashtrash.model.Wallet;
import com.NewCycle.cashtrash.model.exception.WalletNotFoundException;
import com.NewCycle.cashtrash.repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Transactional
public class WalletTransactionService {

    private final WalletRepository walletRepository;

    public WalletTransactionService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public Wallet earn(Long walletId,BigDecimal amount){
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFoundException(walletId));

        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("valor invalido");
        }

            wallet.setAmount(wallet.getAmount().add(amount));
            return walletRepository.save(wallet);
    }

    public Wallet spend(Long walletId, BigDecimal amount){

        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new RuntimeException("valor invalido");
        }

        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFoundException(walletId));

        if (wallet.getAmount().compareTo(amount) < 0){
            throw new RuntimeException("saldo insuficente: " + wallet.getAmount());
        }

            wallet.setAmount(wallet.getAmount().subtract(amount));
            return walletRepository.save(wallet);
    }
}
