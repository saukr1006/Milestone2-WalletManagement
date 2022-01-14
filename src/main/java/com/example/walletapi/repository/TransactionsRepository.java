package com.example.walletapi.repository;

import com.example.walletapi.entity.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionsRepository extends JpaRepository<Transactions,Integer> {

}
