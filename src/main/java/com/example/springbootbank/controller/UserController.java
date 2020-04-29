package com.example.springbootbank.controller;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.Faq;
import com.example.springbootbank.model.User;
import com.example.springbootbank.service.FaqService;
import com.example.springbootbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class UserController {
    public static int n=2;
    @Autowired
    private UserService us;
    @Autowired
    private FaqService fs;
    @Autowired 
    private  FaqService fs;
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public List<User> getAll(){
        return fs.findAll();
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(@ModelAttribute("user") User user, HttpServletRequest request){
        User u=us.getByEmail(user.getEmail());
        ModelAndView mv=new ModelAndView();
        if(user.getEmail().equals("admin@saarthi.com") & user.getPassword().equals("admin")){
            List<Faq> list=fs.findAll();
            mv.setViewName("adminPage");
            mv.addObject("faqs",list);
            request.getSession().setAttribute("session",user.getEmail());
            return mv;
        }
        if(u!=null  && u.getPassword().equals(user.getPassword())){
            mv.setViewName("home");
            mv.addObject("user",u);
            List<Account> list=us.getAllByUserId(u.getUser_id());
            mv.addObject("alist",list);
            request.getSession().setAttribute("session",user.getEmail());
            request.getSession(false).setAttribute("uid",u.getUser_id());
            if(request.getSession(false).getAttribute("msg")!=null){
                 request.getSession(false).removeAttribute("msg");
            }
            return mv;
        }if(n==0){
            n=2;
            u.setLog_status("L");u.setLockDate(new Date());
            us.update(u);
            request.getSession(false).setAttribute("msgD","Your accounts has been locked");
            mv.setViewName("redirect:/");
            return mv;
        }
        n--;
        request.getSession().setAttribute("msgD","Wrong username or password only "+(n+1)+" attempts left");
        mv.setViewName("redirect:/");
        return mv;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user")User user, HttpServletRequest request, Model model){
        us.save(user);
        Account account=new Account();
        account.setUser_id(user.getUser_id());
        account.setUser_type(user.getUser_Type());
        model.addAttribute("account",account);
        request.setAttribute("user_id",user.getUser_id());
        request.setAttribute("user_type",user.getUser_Type());
        return "openAccount";
    }

    @RequestMapping(value = "/addAccount",method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("account")Account account, HttpServletRequest request){
        us.makeDefaultAccount(account);
        request.getSession().setAttribute("msg","Your account has been successfully created please log in");
        if(request.getSession().getAttribute("session")!=null){
            return "redirect:home";
        }
        return "redirect:/";
    }


}
