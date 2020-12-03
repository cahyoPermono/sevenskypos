package com.digimanindo.sevenskypos.payload.request;

import java.util.List;

import com.digimanindo.sevenskypos.models.TransactionDetails;

import lombok.Data;

@Data
public class TransactionRequest {
	private Long customerId;
	private Double total;
	private List<TransactionDetails> transDetails;
	private String date;
}
