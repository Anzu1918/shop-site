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

import com.co.chubb.test.entity.Item;
import com.co.chubb.test.entity.ItemWithdrawl;
import com.co.chubb.test.entity.Stock;
import com.co.chubb.test.service.ItemService;
import com.co.chubb.test.service.StockService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1/item")
@RequiredArgsConstructor

@SuppressWarnings("rawtypes")
public class ItemRestController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    ItemService itemService;
    
	@Autowired
	StockService stockService;
	
    @GetMapping
    public ResponseEntity<List<Item>> findAllItems() {
    	
    	try {	
    		return ResponseEntity.ok(itemService.findAllItems());
    	} catch (Exception e) {
    		return ResponseEntity.noContent().build();
    	}
    }

    @PostMapping
    public ResponseEntity createItem(@Valid @RequestBody Item item) {
    	
    	try {
    		return ResponseEntity.ok(itemService.saveItem(item));
    	} catch (Exception e) {
    		return ResponseEntity.badRequest().build();
    	}
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> findById(@PathVariable Long id) {
        
    	Optional<Item> item = itemService.findItemByCode(id);
        if (!item.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(item.get());
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @Valid @RequestBody Item item) {
    	
    	if (!itemService.findItemByCode(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(itemService.saveItem(item));
        
    }
    
    @PutMapping("/withdrawl/{id}")
    public ResponseEntity<Stock> withDrawlItem(@PathVariable Long id, @Valid @RequestBody ItemWithdrawl item){
    	
    	if(!itemService.findItemByCode(id).isPresent()) {
    		return ResponseEntity.status(HttpStatus.CONFLICT).build();
    	} else {
    		Optional<Item> itemDetail = itemService.findItemByCode(id);
    		
    		if(!stockService.findStockByCode(itemDetail.get().getStockId()).isPresent()) {
    			return ResponseEntity.status(HttpStatus.CONFLICT).build();
    		} else {
    		
				Optional<Stock> stockDetail = stockService.findStockByCode(itemDetail.get().getStockId());
				
				if(item.getWithdrawlQuantity() > stockDetail.get().getUnitsAvailable()) {
					return ResponseEntity.status(HttpStatus.CONFLICT).build();
				} else {
					
					Stock updatedStock = new Stock();
					updatedStock.setId(stockDetail.get().getId());
					updatedStock.setCode(stockDetail.get().getCode());
					updatedStock.setUnitsSold(stockDetail.get().getUnitsSold() + item.getWithdrawlQuantity());
					updatedStock.setUnitsAvailable(stockDetail.get().getUnitsAvailable() - item.getWithdrawlQuantity());
					
					return ResponseEntity.ok(stockService.saveStock(updatedStock));
					
				}

    		}
    		
    	}
    	
    }

}