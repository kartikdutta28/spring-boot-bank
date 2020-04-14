package com.example.springbootbank.controller;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.User;
import com.example.springbootbank.service.AccountService;
import com.example.springbootbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    UserService us;
    @Autowired
    AccountService as;

    @RequestMapping(value = "newAccount/{id}",method = RequestMethod.GET)
    public ModelAndView getNewAccForm(@PathVariable(name = "id") int id){
        ModelAndView mv=new ModelAndView("newAccForm");
        Account account=new Account();
        User user=us.getByUserId(id);
        account.setUser_id(user.getUser_id());
        account.setUser_type(user.getUser_Type());
        mv.addObject("account",account);
        return  mv;
    }
}
