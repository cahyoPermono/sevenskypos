package com.digimanindo.sevenskypos.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digimanindo.sevenskypos.models.Transaction;
import com.digimanindo.sevenskypos.models.TransactionDetails;
import com.digimanindo.sevenskypos.payload.request.TransactionRequest;
import com.digimanindo.sevenskypos.repository.TransactionDetailsRepository;
import com.digimanindo.sevenskypos.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transactionRepository;

	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	public Transaction createTransaction(@Valid TransactionRequest request, LocalDateTime reqDate) {
		// create transaction
		Transaction transaction = new Transaction();
		transaction.setCustomerId(request.getCustomerId());
		transaction.setTotal(request.getTotal());
		transaction.setDate(reqDate);

		for (TransactionDetails detail : request.getTransDetails()) {
			transaction.getTransactionDetails().add(detail);
		}

		return transactionRepository.save(transaction);
	}

	public List<Transaction> getAllTransaction() {
		return transactionRepository.findAll();
	}

}
