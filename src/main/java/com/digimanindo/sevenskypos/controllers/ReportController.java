package com.digimanindo.sevenskypos.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digimanindo.sevenskypos.models.Transaction;
import com.digimanindo.sevenskypos.repository.TransactionRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/report")
public class ReportController {

	@Autowired
	TransactionRepository transactionRepository;

	@GetMapping("/transaction/month/{month}/year/{year}")
	public List<Transaction> getTransactionByMonthAndYear(@PathVariable("month") Integer month,
			@PathVariable("year") Integer year) {
		YearMonth periode = YearMonth.of(year, month);

		LocalDateTime start = periode.atDay(1).atStartOfDay();
		LocalDateTime end = periode.atEndOfMonth().atTime(23, 59);

		return transactionRepository.findByDateGreaterThanAndDateLessThan(start, end);
	}

}
