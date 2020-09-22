package com.co.chubb.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import com.co.chubb.test.entity.Item;

@Component
@RepositoryRestResource
public interface ItemRepository extends JpaRepository<Item, Long> {

}
