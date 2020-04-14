package com.example.springbootbank.service;

import com.example.springbootbank.model.Faq;
import com.example.springbootbank.repository.FaqRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaqService {

    @Autowired
    private FaqRepository fr;

    public List<Faq> findAll(){
        return fr.findAll();
    }

    public void save(Faq faq){
        fr.save(faq);
    }

    public Faq findById(Long id){
        return fr.findById(id).get();
    }
}
