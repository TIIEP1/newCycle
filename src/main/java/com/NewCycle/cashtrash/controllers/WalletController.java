package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.dtos.response.ResponseGetWallet;
import com.NewCycle.cashtrash.dtos.response.ResponseGetWalletBalance;
import com.NewCycle.cashtrash.model.Wallet;
import com.NewCycle.cashtrash.services.WalletService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/wallets")
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

    @GetMapping("/{id}/balance")
    public ResponseEntity<ResponseGetWalletBalance> getWalletBalance(@PathVariable Long id){
        ResponseGetWalletBalance wallet = service.getWalletBalance(id);
        return ResponseEntity.ok(wallet);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseGetWallet> findById(@PathVariable Long id){
        ResponseGetWallet wallet = service.findById(id);
        return ResponseEntity.ok(wallet);
    }
}
