package com.example.springbootbank.controller;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.Transaction;
import com.example.springbootbank.repository.UserRepository;
import com.example.springbootbank.service.TransactionService;
import com.example.springbootbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private UserService ur;
    @Autowired
    private TransactionService ts;

    @RequestMapping(value = "/transaction/{id}",method = RequestMethod.GET)
    public String showTransactionForm(@PathVariable(name = "id")int id, Model model){
        Transaction transaction=new Transaction();
        List<Account> list=ur.getAllByUserId(id);
        transaction.setUserId(id);
        model.addAttribute("transaction",transaction);
        model.addAttribute("alist",list);
        return "transaction_form";
    }

    @RequestMapping(value = "/saveTransaction",method = RequestMethod.POST)
    public String saveTransaction(@ModelAttribute("transaction")Transaction transaction,HttpServletRequest request){
        boolean f=ts.save(transaction);
        if(f==false){
            request.getSession(false).setAttribute("msg",null);
            request.getSession(false).setAttribute("msgD","Sorry you don't have sufficient balance to withdraw");
        }else if(transaction.getTransactionType().equals("W")){
            request.getSession(false).setAttribute("msgD",null);
            request.getSession(false).setAttribute("msg","Account successfully withdrawn");
        }else{
            request.getSession(false).setAttribute("msgD",null);
            request.getSession(false).setAttribute("msg","Amount successfully deposited");
        }
        return  "redirect:home";
    }


    @RequestMapping(value = "getStatementByn/{id}",method = RequestMethod.GET)
    public ModelAndView getStatementByNum(@PathVariable("id")int user_id, HttpServletRequest request) throws ParseException {
        String start=request.getParameter("number");
        List<Transaction> list=ts.getByLimit(user_id, Integer.parseInt(start));
        ModelAndView mv=new ModelAndView("statement");
        mv.addObject("tlist",list);
        return mv;
    }
      /*@RequestMapping(value = "getStatement/{id}",method = RequestMethod.GET)
    public ModelAndView getStatementByDate(@PathVariable("id")int user_id, HttpServletRequest request) throws ParseException {
        String start=request.getParameter("start");
        String end=request.getParameter("end");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date sdate = formatter.parse(start);
        Date edate=formatter.parse(end);
        List<Transaction> list=ts.getByDateRange(user_id,sdate,edate);
        ModelAndView mv=new ModelAndView("statement");
        mv.addObject("tlist",list);
        return mv;
    }
*/
}
