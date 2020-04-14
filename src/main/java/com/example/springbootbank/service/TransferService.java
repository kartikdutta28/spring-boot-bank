package com.example.springbootbank.service;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.Transfer;
import com.example.springbootbank.repository.AccountRepository;
import com.example.springbootbank.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class TransferService {
    @Autowired
    private AccountRepository ar;
    @Autowired
    private TransferRepository tr;

    public boolean save(Transfer transfer){
        Account account=ar.findByAccountId(transfer.getFrom_account());

        if(account.getAmount()<transfer.getAmount()){
            return false;
        }else{
            Random random=new Random();
            int trans_id=Integer.parseInt(String.format("%04d", random.nextInt(1000000)));
            transfer.setTransfer_id(trans_id);
            transfer.setTdate(new Date());
            account.setAmount(account.getAmount()-transfer.getAmount());
            account.setCounter(account.getCounter()+1);
            Account target=ar.findByAccountId(transfer.getTarget_account());
            target.setAmount(target.getAmount()+transfer.getAmount());
        }
        tr.save(transfer);
        return true;
    }
}
