package com.example.springbootbank;

import com.example.springbootbank.model.Transaction;
import com.example.springbootbank.model.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/*
@Aspect
@Component
public class myAspects {
    @After( value = "execution(* com.example.springbootbank.controller.UserController.login(..)) and args(user,request)")
    public void afterLogin(JoinPoint joinPoint, User user, HttpServletRequest request){
        System.out.println(request.getSession(false).getAttribute("session"));
        System.out.println("After Log in");
    }
    @Before(value = "execution(* com.example.springbootbank.controller.AppController.getHome(..)) and args(request)")
    public void afterTransaction(JoinPoint joinPoint,HttpServletRequest request){
        System.out.println(request.getSession(false).getAttribute("msg"));
        request.getSession(false).setAttribute("msg",null);
        System.out.println(request.getSession(false).getAttribute("msg"));
    }

}
*/
