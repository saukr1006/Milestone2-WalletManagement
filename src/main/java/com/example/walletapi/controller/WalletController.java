package com.example.walletapi.controller;

import com.example.walletapi.exception.UserAlreadyHasWalletException;
import com.example.walletapi.exception.UserNotFoundException;
import com.example.walletapi.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WalletController {
    @Autowired
    private WalletService service;

    @PostMapping("/create-wallet/{phoneNumber}")
    public ResponseEntity<?> createWallet(@PathVariable("phoneNumber") String phNo){
        try {
            service.createWallet(phNo);
            return ResponseEntity.ok().body(service.find(phNo));
        } catch (UserNotFoundException e) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        } catch (UserAlreadyHasWalletException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
}
