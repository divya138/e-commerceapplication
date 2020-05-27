package com.ecommerceapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapplication.model.Product;
import com.ecommerceapplication.service.ProductService;
@RestController
public class ProductController {
	@Autowired
	private ProductService productService; 
	
	@GetMapping("products1/{name}")
	public ResponseEntity<List<Product>> findProductByName(@PathVariable String name) {
		System.out.println(name);
		List<Product> product=productService.findProductByName(name);
		 return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}
	@GetMapping(value = "/product")
	public ResponseEntity<List<Product>> getAllProduct() {
		  List<Product> product1=productService.getAllProducts();
	        return new ResponseEntity <List<Product>>(product1,HttpStatus.OK);
	    }
	

	@GetMapping(value = "/productex/{product}")
	public ResponseEntity<Product> getProductById(@PathVariable("product") int productId) {
		Product product = productService.getProductById(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PostMapping(value = "/product")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		Product product1 = productService.addProduct(product);
		return new ResponseEntity<Product>(product1, HttpStatus.OK);
	}

	@PutMapping(value = "/product")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product product2 = productService.updateProduct(product);
		return new ResponseEntity<Product>(product2, HttpStatus.OK);
	}


}
