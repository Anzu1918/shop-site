package com.co.chubb.test.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.co.chubb.test.entity.Item;
import com.co.chubb.test.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service

@Component
@RequiredArgsConstructor
public class ItemService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
    ItemRepository itemRespository;

    public List<Item> findAllItems() {
        return itemRespository.findAll();
    }

    public Optional<Item> findItemByCode(Long code) {
        return itemRespository.findById(code);
    }

    public Item saveItem(Item item) {
        return itemRespository.save(item);
    }

}