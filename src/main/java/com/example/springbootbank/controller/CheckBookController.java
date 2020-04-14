package com.example.springbootbank.controller;

import com.example.springbootbank.model.CheckBook;
import com.example.springbootbank.service.CheckBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckBookController {
    @Autowired
    private CheckBookService cs;
    @GetMapping("reqCkBook")
    public ModelAndView ckBookForm(){
        CheckBook checkBook=new CheckBook();
        ModelAndView modelAndView=new ModelAndView("ckBookForm");
        modelAndView.addObject("ck",checkBook);
        return modelAndView;
    }
    @PostMapping("saveCheckBook")
    public String saveCheckBook(@ModelAttribute("ck")CheckBook checkBook, HttpServletRequest request){

        boolean f=cs.save(checkBook);
        if(f==false){
            request.getSession(false).setAttribute("msgD","Check Book Request already exists");
            return "redirect:home";
        }else {
            return "redirect:home";
        }
    }
}
