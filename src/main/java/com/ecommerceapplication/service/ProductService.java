package com.ecommerceapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerceapplication.exception.ProductNotFoundException;
import com.ecommerceapplication.model.Product;
import com.ecommerceapplication.repositroy.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findProductByName(String name) {
		List<Product> products = productRepository.findProductByProductNameLike("%" + name + "%");
		if (products.isEmpty()) {
			throw new ProductNotFoundException(name);
		} else {
			return products;
		}
	}

	public List<Product> getAllProducts() {

		return (List<Product>) productRepository.findAll();
	}

	public Product addProduct(Product product) {

		return productRepository.save(product);
	}

	public Product getProductById(int productId) {

		return productRepository.getOne(productId);
	}

	public Product updateProduct(Product product) {

		return productRepository.save(product);
	}

}
