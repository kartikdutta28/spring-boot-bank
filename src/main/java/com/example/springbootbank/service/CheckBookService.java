package com.example.springbootbank.service;

import com.example.springbootbank.model.CheckBook;
import com.example.springbootbank.repository.CheckBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class CheckBookService {
    @Autowired
    private CheckBookRepository cr;
    public boolean save(CheckBook checkBook){
        CheckBook ck=cr.findByAccount_Id(checkBook.getAccount_id());
        if(ck==null){
            Calendar c=Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE,10);
            checkBook.setReqDate(new Date());
            checkBook.setDeliveryDate(c.getTime());
            checkBook.setRequestStatus("A");
            cr.save(checkBook);
            return true;
        }
        return false;
    }

}
