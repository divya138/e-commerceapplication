package com.ecommerceapplication.service;

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
import org.mockito.junit.MockitoJUnitRunner;

import com.ecommerceapplication.exception.ProductNotFoundException;
import com.ecommerceapplication.model.Product;
import com.ecommerceapplication.repositroy.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {
	@InjectMocks

	ProductService productService;

	@Mock
	ProductRepository productRepository;
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

	@Test(expected = ProductNotFoundException.class)
	public void testForProductNameStringWithLikeEx() {
		List<Product> products = new ArrayList();
		products.add(product);
		Mockito.when(productRepository.findProductByProductNameLike("watch")).thenReturn(products);
		List<Product> result = productService.findProductByName("watch");
		Assert.assertNotNull(result);
	}

	@Test
	public void testForProductNameStringWithLike() {
		List<Product> products = new ArrayList();
		products.add(product);
		Mockito.when(productRepository.findProductByProductNameLike(Mockito.anyString())).thenReturn(products);
		List<Product> result = productService.findProductByName("watch");
		Assert.assertNotNull(result);
	}

	@Test
	public void testupdateProduct() {
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Product s1 = productService.updateProduct(product);
		Assert.assertNotEquals("sama", s1.getProductName());
	}
	@Test
	public void testupdateProductNe() {
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Product s1 = productService.updateProduct(product);
		Assert.assertNotEquals("-sama", s1.getProductName());
	}
	@Test
	public void testaddProduct() {
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Product s1 = productService.addProduct(product);
		Assert.assertNotEquals("sama", s1.getProductName());
	}
	@Test
	public void testaddProductNe() {
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Product s1 = productService.addProduct(product);
		Assert.assertNotEquals("-sama", s1.getProductName());
	}

	@Test
	public void testGetAllProductsForPostivte() {
		List<Product> products = new ArrayList();
		products.add(product);
		Mockito.when(productService.getAllProducts()).thenReturn(products);
		Assert.assertEquals(1, products.size());

	}

	@Test
	public void testForFinfByIdForPostivte() {
		Mockito.when(productRepository.getOne(Mockito.anyInt())).thenReturn(product);
		Product product1 = productService.getProductById(2);
		Assert.assertNotNull(product1);
		Assert.assertEquals(12, product1.getProductId());
		}
	@AfterClass
	public static void tearDown() {
		product = null;

	}
}
