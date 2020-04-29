package com.example.springbootbank.repository;

import com.example.springbootbank.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query(nativeQuery = true,value = "SELECT * FROM Transaction where user_id = :id ORDER BY date DESC LIMIT :l")
    List<Transaction> getByLimit(@Param("id")int id,@Param("l")int n);
}
