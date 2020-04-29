package com.example.springbootbank.service;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.User;
import com.example.springbootbank.repository.AccountRepository;
import com.example.springbootbank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService{
    @Autowired
    private UserRepository ur;
    @Autowired
    private AccountRepository ar;

    public User getByEmail(String email){
        return ur.findByEmail(email);
    }


    public void save(User user){
        System.out.println(user.getUser_id());
        Random random=new Random();
        if(user.getUser_id()!=0){
            user.setLog_status("O");
            user.setLockDate(null);
        }else{
            int user_id=Integer.parseInt(String.format("%04d", random.nextInt(10000)));
            user.setUser_id(user_id);
            String transaction_password=(String.format("%04d", random.nextInt(10000)));
            user.setTransaction_password(transaction_password);
        }

        ur.save(user);
    }

    public void update(User  user){
        ur.save(user);
    }

    public void makeDefaultAccount(Account account){
        Random random=new Random();
        int acc_id=Integer.parseInt(String.format("%04d", random.nextInt(1000000)));
        account.setAccount_id(acc_id);
        account.setCreation_date(new Date());
        account.setLock_date(null);
        account.setLock_stat("O");
        account.setCounter(0);
        ar.save(account);
    }

    public List<Account> getAllByUserId(int id){
        return ar.findByUser_Id(id);
    }

    public User getByUserId(int id){
        return ur.findByUser_Id(id);
    }

    public List<User> listAll(){
        return (List<User>) ur.findAll();
    }


}
