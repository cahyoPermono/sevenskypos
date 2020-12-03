package com.digimanindo.sevenskypos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digimanindo.sevenskypos.models.TransactionDetails;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

}
