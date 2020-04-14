package com.example.springbootbank.service;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository ar;

    public Account  findByAccountId(int id){
        return  ar.findByAccountId(id);
    }

    public List<Account> getTargetAccounts(int id){
        return  ar.getTargetAccounts(id);
    }
}
