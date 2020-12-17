package com.digimanindo.sevenskypos.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimanindo.sevenskypos.models.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findByDateGreaterThanAndDateLessThan(LocalDateTime start, LocalDateTime end);

}
