package com.example.springbootbank.controller;

import com.example.springbootbank.model.Faq;
import com.example.springbootbank.service.FaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FaqController {
    @Autowired
    private FaqService fs;

    @RequestMapping(value = "/faq",method = RequestMethod.GET)
    public ModelAndView getFaqPage(){
        ModelAndView modelAndView=new ModelAndView("faq");
        Faq faq=new Faq();
        modelAndView.addObject("faq",faq);
        List<Faq>faqs=fs.findAll();
        modelAndView.addObject("faqs",faqs);
        return modelAndView;
    }

    @RequestMapping(value = "/saveFaq" ,method = RequestMethod.POST)
    public String saveFaq(@ModelAttribute("faq")Faq faq){
        System.out.println(faq.getId());
        System.out.println(faq.getQuestion());
        System.out.println(faq.getAnswer());
        System.out.println(faq.getUserName());
        fs.save(faq);
        return "redirect:adminPage";
    }
    @RequestMapping(value = "/adminPage",method = RequestMethod.GET)
    public ModelAndView getAdminPage(){
        ModelAndView mv=new ModelAndView();
        List<Faq> list=fs.findAll();
        mv.setViewName("adminPage");
        mv.addObject("faqs",list);
        return mv;
    }
    @RequestMapping(value = "/answerFaq/{id}",method = RequestMethod.GET)
    public ModelAndView answerFaqForm(@PathVariable("id")Long id){
        ModelAndView mv=new ModelAndView("answerFaqForm");
        Faq faq=fs.findById(id);
        mv.addObject("faq",faq);
        return mv;
    }

}
