package com.poc.hexaware.azurePoc.service;

import com.poc.hexaware.azurePoc.dto.AccountsDto;
import com.poc.hexaware.azurePoc.entity.Accounts;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IAccountService {

    public void createAccounts( AccountsDto accountsDto);
    public Accounts updateAccountsDetails(String accountNumber, String accountType , String accountAddress);
    public List<Accounts> getAllAccounts();
    public void deleteAccount(String accountNumber);
}
