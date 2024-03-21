package com.jsp.springboot.Service;

import org.springframework.http.ResponseEntity;

import com.jsp.springboot.Entity.Product;
import com.jsp.springboot.Utility.ResponseStructure;

public interface ProductService {
	
	ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);

	ResponseEntity<ResponseStructure<Product>> findProduct(int productId);
	
}
