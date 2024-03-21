package com.jsp.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsp.springboot.Entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
