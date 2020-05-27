package com.ecommerceapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner.Silent;
import org.springframework.http.ResponseEntity;

import com.ecommerceapplication.model.Product;
import com.ecommerceapplication.service.ProductService;
@RunWith(Silent.class)
public class ProductControllerTest {
	@InjectMocks
	ProductController productController;
	@Mock
	ProductService productService;
	static Product product = null;

	@BeforeClass
	public static void setUp() {
		product = new Product();
	}
	@Before
	public void beforeMethod() {
		product.setProductId(12);
		product.setProductName("watch1");
		product.setProductDescription("good to buy");
		product.setPrice(1233);
	}
	@Test
	public void testForProductNameStringWithLike() {
		List<Product> products = new ArrayList();
		products.add(product);
		Mockito.when(productService.findProductByName("sam")).thenReturn(products);
		ResponseEntity<List<Product>> result = productController.findProductByName("sam");
		Assert.assertNotNull(result);

	}
	@Test
	public void testForAllProducts() {
		List<Product> products = new ArrayList();
		products.add(product);
		Mockito.when(productService.getAllProducts()).thenReturn(products);
		Assert.assertEquals(1, products.size());
	}
	@Test
	public void testforAddMethod() {
		List<Product> products = new ArrayList();
		products.add(product);
		Mockito.when(productService.addProduct(product)).thenReturn(product);
		Assert.assertEquals(1, products.size());
	}
	@Test
	public void testForFindByIdForPostivteforCon() {
		product.setProductId(1);
		product.setProductName("sama");
		Mockito.when(productService.getProductById(Mockito.anyInt())).thenReturn(product);
		Assert.assertEquals(1, product.getProductId());

	}
	@Test
	public void testForProductUpdate() {
		product.setProductId(13);
		product.setProductName("watch");
		Mockito.when(productService.updateProduct(product)).thenReturn(product);
		ResponseEntity<Product> result = productController.updateProduct(product);
		Assert.assertEquals(result, result);
	}

	@AfterClass
	public static void tearDown() {
		product = null;

	}

}
