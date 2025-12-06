package com.poc.hexaware.azurePoc.service.impl;

import com.poc.hexaware.azurePoc.dto.AccountsDto;
import com.poc.hexaware.azurePoc.entity.Accounts;
import com.poc.hexaware.azurePoc.exception.AccountsNotFound;
import com.poc.hexaware.azurePoc.mapper.AccountMapper;
import com.poc.hexaware.azurePoc.repository.IAccoutsRepository;
import com.poc.hexaware.azurePoc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountserviceImpl implements IAccountService {

    @Autowired
    private IAccoutsRepository iAccoutsRepository;

    @Override
    public void createAccounts(AccountsDto accountsDto) {
        Accounts accounts = AccountMapper.mapDtoToCustomerEntity(accountsDto);
        iAccoutsRepository.save(accounts);
    }

    @Override
    public Accounts updateAccountsDetails(String accountNumber,String accountType ,String accountAddress) {

        Optional<Accounts> accountByAccNumer = iAccoutsRepository.findById(Integer.parseInt(accountNumber));
        accountByAccNumer.orElseThrow(() ->  new AccountsNotFound(accountNumber));

        Accounts accounts = accountByAccNumer.get();
        accounts.setAccountType(accountType);
        accounts.setBranchAddress(accountAddress);

        return  iAccoutsRepository.save(accounts);

    }

    @Override
    public List<Accounts> getAllAccounts() {
        return iAccoutsRepository.findAll();
    }

    @Override
    public void deleteAccount(String accountNumber) {
        iAccoutsRepository.deleteById(Integer.parseInt(accountNumber));
    }
}
