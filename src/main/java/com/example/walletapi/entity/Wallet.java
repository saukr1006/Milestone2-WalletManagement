package com.example.walletapi.entity;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int walletId;


    private float balance;

    @OneToOne(mappedBy = "wallet")
    private User walletOfUser;

    @OneToMany(mappedBy = "txnToWallet")
    private List<Transactions> toWalletTxn;

    @OneToMany(mappedBy = "txnFromWallet")
    private List<Transactions> fromWalletTxn;

    public Wallet() {
        this.balance = 450;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public User getWalletOfUser() {
        return walletOfUser;
    }

    public void setWalletOfUser(User walletOfUser) {
        this.walletOfUser = walletOfUser;
    }

    public List<Transactions> getToWalletTxn() {
        return toWalletTxn;
    }

    public void setToWalletTxn(List<Transactions> toWalletTxn) {
        this.toWalletTxn = toWalletTxn;
    }

    public List<Transactions> getFromWalletTxn() {
        return fromWalletTxn;
    }

    public void setFromWalletTxn(List<Transactions> fromWalletTxn) {
        this.fromWalletTxn = fromWalletTxn;
    }
}
