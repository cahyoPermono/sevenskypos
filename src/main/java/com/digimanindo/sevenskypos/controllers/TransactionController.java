package com.digimanindo.sevenskypos.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digimanindo.sevenskypos.models.Transaction;
import com.digimanindo.sevenskypos.payload.request.TransactionRequest;
import com.digimanindo.sevenskypos.security.services.TransactionService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Autowired
	TransactionService transactionService;

	@GetMapping("")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Transaction> getAllTransaction() {
		return null;
	}

	@PostMapping("")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public Transaction createTransaction(@Valid @RequestBody TransactionRequest request) {

		LocalDateTime reqDate = LocalDateTime.parse(request.getDate(), formatter);

		return transactionService.createTransaction(request, reqDate);
	}

}
