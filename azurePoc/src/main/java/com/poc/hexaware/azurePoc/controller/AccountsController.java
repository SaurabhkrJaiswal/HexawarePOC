package com.poc.hexaware.azurePoc.controller;

import com.poc.hexaware.azurePoc.dto.AccountsDto;
import com.poc.hexaware.azurePoc.dto.ResponseDto;
import com.poc.hexaware.azurePoc.entity.Accounts;
import com.poc.hexaware.azurePoc.mapper.AccountMapper;
import com.poc.hexaware.azurePoc.service.impl.AccountserviceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {
    private static final Logger logger = LoggerFactory.getLogger(AccountsController.class);

    private final AccountserviceImpl accountService;

    public AccountsController(AccountserviceImpl accountService){
        this.accountService = accountService;
    }

    @PostMapping(value = "/create")
    public void createAccounts(@RequestBody AccountsDto accountsDto){
        accountService.createAccounts(accountsDto);
    }

    @PutMapping(path = "/update/{accountNumber}/{accountType}/{address}")
    public ResponseEntity<ResponseDto> updateAccountsType(@PathVariable("accountNumber") String accountNumber,
                                                          @PathVariable("accountType") String accountType,
                                                          @PathVariable("address") String address){

        Accounts accounts = accountService.updateAccountsDetails(accountNumber, accountType, address);

       return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseDto("Updated Successfully","200"));

    }

    @GetMapping("/getAllAccounts")
    public List<AccountsDto> getAllAccounts(String accountNumber){

        List<Accounts> allAccounts = accountService.getAllAccounts();
        return allAccounts.stream().map(AccountMapper::mapEntityToCustomerDTO).toList();
    }

    @DeleteMapping("/delete/{accountNumber}")
    public ResponseEntity<ResponseDto> deleteAccounts(@PathVariable("accountNumber") String accountNumber){
        accountService.deleteAccount(accountNumber);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new ResponseDto("Deleted Successfully", "200"));
    }
}
