package com.example.springbootbank.repository;

import com.example.springbootbank.model.CheckBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckBookRepository extends CrudRepository<CheckBook,Long> {
    @Query("FROM CheckBook c where c.account_id = :id")
    CheckBook findByAccount_Id(@Param("id") int account_id);
}
