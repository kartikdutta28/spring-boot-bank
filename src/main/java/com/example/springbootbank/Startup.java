package com.example.springbootbank;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.User;
import com.example.springbootbank.service.AccountService;
import com.example.springbootbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Component
public class Startup {
    @Autowired
    private UserService us;

    @PostConstruct
    public void init(){
        List<User>list=us.listAll();
        for(User u:list){
            if(u.getLog_status().equals("L")){
                System.out.println("User is with "+u.getFirst_name()+" is locked let us check first");
                if(u.getLockDate().compareTo(new Date())<0){
                    System.out.println("User with name "+u.getFirst_name()+" is unlocked now");
                    u.setLog_status("O");u.setLockDate(null);
                    us.update(u);
                }
            }else{
                System.out.println("User with name "+u.getFirst_name()+" is already unlocked");
            }
        }
    }
}
