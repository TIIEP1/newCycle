package com.NewCycle.cashtrash.services;

import com.NewCycle.cashtrash.model.User;
import com.NewCycle.cashtrash.model.UserAlreadyHasWallet;
import com.NewCycle.cashtrash.model.UserNotFoundException;
import com.NewCycle.cashtrash.model.Wallet;
import com.NewCycle.cashtrash.repositories.UserRepository;
import com.NewCycle.cashtrash.repositories.WalletRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    private final WalletRepository repository;
    private final UserRepository userRepository;

    public WalletService(WalletRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public Wallet createWallet(Long userId){

        if(repository.findByUserId(userId).isPresent()){
            throw new UserAlreadyHasWallet(userId);
        }

        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setAmount(BigDecimal.ZERO);
        repository.save(wallet);

        return  wallet;
    }

}
