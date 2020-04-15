package com.example.springbootbank.controller;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.User;
import com.example.springbootbank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class AppController {
    @Autowired
    private UserService us;

    @RequestMapping("/")
    public String getHomePage(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "index";
    }

    @RequestMapping("/newUser")
    public String getCreateAccount(Model model){
        User user=new User();
        model.addAttribute("user",user);
        return "newUserForm";
    }

    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request, Model model){
        request.getSession(false).invalidate();
        User user=new User();
        model.addAttribute(user);
        return "redirect:/";
    }

    @RequestMapping("/home")
    public ModelAndView getHome(HttpServletRequest request){
        ModelAndView mv=new ModelAndView("home");
        HttpSession session=request.getSession(false);
        int uid= (Integer) session.getAttribute("uid");
        User user=us.getByUserId(uid);
        List<Account> list=us.getAllByUserId(uid);
        mv.addObject("user",user);
        mv.addObject("alist",list);
        return mv;
    }
}
