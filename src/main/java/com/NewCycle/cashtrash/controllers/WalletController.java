package com.NewCycle.cashtrash.controllers;

import com.NewCycle.cashtrash.dtos.response.ResponseGetWallet;
import com.NewCycle.cashtrash.dtos.response.ResponseGetWalletBalance;
import com.NewCycle.cashtrash.model.Wallet;
import com.NewCycle.cashtrash.services.WalletService;
import com.NewCycle.cashtrash.services.WalletTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/wallets")
public class WalletController {

    private final WalletService service;
    private final WalletTransactionService walletTransactionService;

    public WalletController(WalletService service, WalletTransactionService walletTransactionService) {
        this.service = service;
        this.walletTransactionService = walletTransactionService;
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

    @PostMapping("/{id}/earn")
    public ResponseEntity<Wallet> earn(@PathVariable Long id, @RequestParam BigDecimal amount){
        Wallet wallet = walletTransactionService.earn(id,amount);
        return ResponseEntity.ok(wallet);
    }

    @PostMapping("/{id}/spend")
    public ResponseEntity<Wallet> spend(@PathVariable Long id, @RequestParam BigDecimal amount){
        Wallet wallet = walletTransactionService.spend(id,amount);
        return ResponseEntity.ok(wallet);
    }
}
