package com.example.springbootbank.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int transactionId;
    private int userId;
    private int accountId;
    private double amount;
    private double postBalance;
    private String transactionType;
    private String comments;
    @Temporal(TemporalType.DATE)
    private Date date;
    public Transaction() {
    }

    public Transaction(Long id, int transactionId, int userId, int accountId, double amount, double postBalance, String transactionType, String comments, Date date) {
        this.id = id;
        this.transactionId = transactionId;
        this.userId = userId;
        this.accountId = accountId;
        this.amount = amount;
        this.postBalance = postBalance;
        this.transactionType = transactionType;
        this.comments = comments;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(double postBalance) {
        this.postBalance = postBalance;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
