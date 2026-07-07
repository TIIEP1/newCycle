package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.model.Wallet;
import com.NewCycle.cashtrash.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/wallet")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping("/user/{id}")
    public ResponseEntity<Wallet> createWallet(@PathVariable Long id){
        Wallet wallet = service.createWallet(id);

        return ResponseEntity.ok(wallet);
    }
}
