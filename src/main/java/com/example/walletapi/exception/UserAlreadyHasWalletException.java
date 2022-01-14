package com.example.walletapi.exception;

public class UserAlreadyHasWalletException extends Throwable {
    private String errorMsg;

    public UserAlreadyHasWalletException() {
        this.errorMsg = "User already has a wallet";
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
