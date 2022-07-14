package com.example.land.repository;

import com.example.land.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select  p from Transaction p where p.id = :id")
    Transaction getById(@Param("id") Long id);
}
