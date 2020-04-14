package com.example.springbootbank.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int transfer_id;
    private int from_account;
    private int target_account;
    private Double amount;
    private String comments;
    private Date tdate;

    public Transfer() {
    }

    public Transfer(Long id, int transfer_id, int from_account, int target_account, Double amount, String comments, Date tdate) {
        this.id = id;
        this.transfer_id = transfer_id;
        this.from_account = from_account;
        this.target_account = target_account;
        this.amount = amount;
        this.comments = comments;
        this.tdate = tdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(int transfer_id) {
        this.transfer_id = transfer_id;
    }

    public int getFrom_account() {
        return from_account;
    }

    public void setFrom_account(int from_account) {
        this.from_account = from_account;
    }

    public int getTarget_account() {
        return target_account;
    }

    public void setTarget_account(int target_account) {
        this.target_account = target_account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }
}
