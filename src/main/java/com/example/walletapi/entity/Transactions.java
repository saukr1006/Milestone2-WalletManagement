package com.example.walletapi.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int txnId;
    private String status;
    private Date timestamp;
    private float amount;
    private float postBalance;
//    private String description;

    @ManyToOne
    @JoinColumn(name = "toWalletId")
    private Wallet txnToWallet;

    @ManyToOne
    @JoinColumn(name = "fromWalletId")
    private Wallet txnFromWallet;

    public Transactions() {
    }

    public int getTxnId() {
        return txnId;
    }

    public void setTxnId(int txnId) {
        this.txnId = txnId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(float postBalance) {
        this.postBalance = postBalance;
    }

//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }

    public Wallet getTxnFromWallet() {
        return txnFromWallet;
    }

    public void setTxnFromWallet(Wallet txnFromWallet) {
        this.txnFromWallet = txnFromWallet;
    }

    public Wallet getTxnToWallet() {
        return txnToWallet;
    }

    public void setTxnToWallet(Wallet txnToWallet) {
        this.txnToWallet = txnToWallet;
    }
}
