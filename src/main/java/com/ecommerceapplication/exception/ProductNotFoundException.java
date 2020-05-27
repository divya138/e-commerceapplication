package com.ecommerceapplication.exception;
public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException(String name) {
		 super(String.format("product with %s not found", name));
	}

}
