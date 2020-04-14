package com.example.springbootbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int account_id;
    private int user_id;
    private double amount;
    private Date creation_date;
    private int counter;
    private String user_type;
    private String lock_stat;
    private  String account_type;
    private Date lock_date;

    public Account() {
    }

    public Account(Long id, int account_id, int user_id, double amount, Date creation_date, int counter, String user_type, String lock_stat, String account_type, Date lock_date) {
        this.id = id;
        this.account_id = account_id;
        this.user_id = user_id;
        this.amount = amount;
        this.creation_date = creation_date;
        this.counter = counter;
        this.user_type = user_type;
        this.lock_stat = lock_stat;
        this.account_type = account_type;
        this.lock_date = lock_date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getLock_stat() {
        return lock_stat;
    }

    public void setLock_stat(String lock_stat) {
        this.lock_stat = lock_stat;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Date getLock_date() {
        return lock_date;
    }

    public void setLock_date(Date lock_date) {
        this.lock_date = lock_date;
    }
}
