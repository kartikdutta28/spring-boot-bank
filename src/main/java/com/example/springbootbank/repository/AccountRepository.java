package com.example.springbootbank.repository;

import com.example.springbootbank.model.Account;
import com.example.springbootbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("FROM Account u where u.user_id = :id")
    List<Account> findByUser_Id(@Param("id") int user_id);
    @Query("FROM Account a where a.account_id = :id")
    Account findByAccountId(@Param("id")int id);
    @Query("FROM Account a where a.user_id != :id")
    List<Account> getTargetAccounts(@Param("id")int id);
}
