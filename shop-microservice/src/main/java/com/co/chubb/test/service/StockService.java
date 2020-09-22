package com.co.chubb.test.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.co.chubb.test.entity.Stock;
import com.co.chubb.test.repository.StockRepository;

import lombok.RequiredArgsConstructor;

@Service

@Component
@RequiredArgsConstructor
public class StockService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    StockRepository stockRespository;

    public List<Stock> findAllStocks() {
        return stockRespository.findAll();
    }

    public Optional<Stock> findStockByCode(Long code) {
        return stockRespository.findById(code);
    }

    public Stock saveStock(Stock item) {
        return stockRespository.save(item);
    }

}