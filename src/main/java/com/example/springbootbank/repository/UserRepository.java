package com.example.springbootbank.repository;

import com.example.springbootbank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
    @Query("FROM User u where u.user_id = :id")
    User findByUser_Id(@Param("id") int user_id);
    @Modifying
    @Query("Update User set log_status =:s,lockDate =:d where email=:e")
    void saveLock(@Param("s")String s, @Param("d") Date date ,@Param("e") String email);
}
