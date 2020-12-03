package com.digimanindo.sevenskypos.security.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
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

		// create transaction detail // input trans id to all trans detail
//		List<TransactionDetails> reqDetails = request.getTransDetails().stream().map(e -> {
//			e.setTransaction(transaction);
//			return e;
//		}).collect(Collectors.toList());
		
//		transaction.setTransactionDetails(reqDetails);

		return transactionRepository.save(transaction);
	}

}
