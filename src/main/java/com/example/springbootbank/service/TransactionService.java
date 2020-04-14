package com.example.springbootbank.service;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.Transaction;
import com.example.springbootbank.repository.AccountRepository;
import com.example.springbootbank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository tr;
    @Autowired
    private AccountRepository ar;

    public boolean save(Transaction transaction){
        Random random=new Random();
        int tran_id=Integer.parseInt(String.format("%04d", random.nextInt(1000000)));
        transaction.setTransactionId(tran_id);
        transaction.setDate(new Date());
        Account account=ar.findByAccountId(transaction.getAccountId());
        if(transaction.getTransactionType().equals("W")){
            if(account.getAmount()<transaction.getAmount()){
                 return false;
            }else{
                transaction.setPostBalance(account.getAmount()-transaction.getAmount());
                account.setAmount(account.getAmount()-transaction.getAmount());
            }
        }else{
            transaction.setPostBalance(account.getAmount()+transaction.getAmount());
            account.setAmount(account.getAmount()+transaction.getAmount());

        }
        tr.save(transaction);
        return true;
    }

    public List<Transaction> getByLimit(int id,int l){
        return tr.getByLimit(id,l);
    }

    /*public List<Transaction> getByDateRange(int id,Date start,Date end){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Transaction> query = criteriaBuilder.createQuery(Transaction.class);
        Root<Transaction> employee = query.from(Transaction.class);
        query.select(employee)
                .where(criteriaBuilder.between(employee.get("date"), start, end));
        List<Transaction> resultList = em.createQuery(query).getResultList();
        System.out.println(resultList);
        return  resultList;

    }*/

}
