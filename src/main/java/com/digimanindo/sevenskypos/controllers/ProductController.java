package com.digimanindo.sevenskypos.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digimanindo.sevenskypos.models.Product;
import com.digimanindo.sevenskypos.payload.response.MessageResponse;
import com.digimanindo.sevenskypos.security.services.ProductService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Product> allAccess() {
		return productService.getAllProduct();
	}

	@PostMapping("")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<?> createProduct(@Valid @RequestBody Product product) {
		productService.createProduct(product);

		return ResponseEntity.ok(new MessageResponse("Product created successfully!"));
	}
}
