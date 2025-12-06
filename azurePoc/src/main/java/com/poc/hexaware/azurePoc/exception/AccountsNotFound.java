package com.poc.hexaware.azurePoc.exception;


public class AccountsNotFound extends RuntimeException {

    public AccountsNotFound(String accountNumber) {
        super("Account No:"+accountNumber+"not found");
    }
}
