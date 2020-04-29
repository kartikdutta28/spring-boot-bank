package com.example.springbootbank.repository;

import com.example.springbootbank.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer,Long> {
}
