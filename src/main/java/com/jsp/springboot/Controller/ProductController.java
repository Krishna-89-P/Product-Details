package com.jsp.springboot.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jsp.springboot.Entity.Product;
import com.jsp.springboot.Service.ProductService;
import com.jsp.springboot.Utility.ResponseStructure;

@Controller
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product)
	{
		return productService.saveProduct(product);
	}
	
	public ResponseEntity<ResponseStructure<Product>> findProduct(int productId)
	{
		return productService.findProduct(productId);
	}
}
