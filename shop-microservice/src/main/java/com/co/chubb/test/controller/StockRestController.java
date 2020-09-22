package com.co.chubb.test.controller;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.chubb.test.entity.Stock;
import com.co.chubb.test.service.StockService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/stock")
@RequiredArgsConstructor

@SuppressWarnings("rawtypes")
public class StockRestController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    StockService stockService;
    
    @GetMapping
    public ResponseEntity<List<Stock>> findAllStocks() {
    	
    	try {	
    		return ResponseEntity.ok(stockService.findAllStocks());
    	} catch (Exception e) {
    		return ResponseEntity.noContent().build();
    	}
    }

    @PostMapping
    public ResponseEntity createStock(@Valid @RequestBody Stock stock) {
    	
    	try {
    		return ResponseEntity.ok(stockService.saveStock(stock));
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> findById(@PathVariable Long id) {
        
    	Optional<Stock> stock = stockService.findStockByCode(id);
        if (!stock.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(stock.get());
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateItem(@PathVariable Long id, @Valid @RequestBody Stock stock) {
    	
    	if (!stockService.findStockByCode(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(stockService.saveStock(stock));
        
    }

}