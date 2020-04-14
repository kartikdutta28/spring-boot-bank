package com.example.springbootbank.controller;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.Transfer;
import com.example.springbootbank.service.AccountService;
import com.example.springbootbank.service.TransferService;
import com.example.springbootbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TransferController {
    @Autowired
    private UserService us;
    @Autowired
    private AccountService as;
    @Autowired
    private TransferService ts;

    @RequestMapping("/transfer/{id}")
    public String showTransferForm(@PathVariable(name = "id")int id, Model model){
        Transfer transfer=new Transfer();
        List<Account> list=us.getAllByUserId(id);
        List<Account> tlist=as.getTargetAccounts(id);
        model.addAttribute("transfer",transfer);
        model.addAttribute("alist",list);
        model.addAttribute("tlist",tlist);
        return "transferForm";
    }

    @RequestMapping(value = "/saveTransfer",method = RequestMethod.POST)
    public String saveTransfer(@ModelAttribute("transfer")Transfer transfer, HttpServletRequest request){
        boolean f=ts.save(transfer);
        if(f==true){
            request.getSession(false).setAttribute("msgD",null);
            request.getSession(false).setAttribute("msg","Funds Successfully Transfer");
        }else {
            request.getSession(false).setAttribute("msg",null);
            request.getSession(false).setAttribute("msgD","Sorry not enough funds available to transfer");
        }
        return  "redirect:home";
    }
}
