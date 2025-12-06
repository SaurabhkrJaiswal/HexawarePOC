package com.poc.hexaware.azurePoc.mapper;

import com.poc.hexaware.azurePoc.dto.AccountsDto;
import com.poc.hexaware.azurePoc.dto.ResponseDto;
import com.poc.hexaware.azurePoc.entity.Accounts;

public class AccountMapper {

    public static Accounts mapDtoToCustomerEntity(AccountsDto accountsDto) {
        Accounts accounts = new Accounts();
        accounts.setCustomerId(accountsDto.getCustomerId());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());

        return accounts;
    }

    public static AccountsDto mapEntityToCustomerDTO(Accounts accounts) {
        AccountsDto accountsDto = new AccountsDto();
        accountsDto.setCustomerId(accounts.getCustomerId());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());

        return accountsDto;
    }




}
