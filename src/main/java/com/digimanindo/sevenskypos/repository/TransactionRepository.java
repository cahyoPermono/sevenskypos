package com.digimanindo.sevenskypos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimanindo.sevenskypos.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
