package com.jsp.springboot.ServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.springboot.Entity.Product;
import com.jsp.springboot.Repository.ProductRepository;
import com.jsp.springboot.Service.ProductService;
import com.jsp.springboot.Utility.ResponseStructure;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;

	private ResponseStructure<Product> structure;
	
	
	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
		
		Product product1 = productRepository.save(product);
		
		ResponseStructure<Product> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Product saved successfully!");
		responseStructure.setData(product1);

		return new ResponseEntity<ResponseStructure<Product>>(responseStructure, HttpStatus.CREATED);
	}

	public ProductServiceImpl(ProductRepository productRepository, ResponseStructure<Product> structure) {
		super();
		this.productRepository = productRepository;
		this.structure = structure;
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findProduct(int productId) {

		return productRepository.findById(productId)
				.map(product -> ResponseEntity
				.ok(structure.setStatus(HttpStatus.OK.value())
				.setMessage("Product found")
				.setData(product)))
				.orElseThrow(() -> new RuntimeException());
	}
}