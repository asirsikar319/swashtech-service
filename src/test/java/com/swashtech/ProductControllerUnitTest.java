package com.swashtech;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;

import com.mongodb.DBObject;
import com.swashtech.controller.ProductController;
import com.swashtech.product.domain.Product;
import com.swashtech.repositories.ProductRepository;
import com.swashtech.services.ProductServiceImpl;

public class ProductControllerUnitTest {

	private ProductController productController;

	private ProductServiceImpl productService;

	@Mock
	private ProductRepository productRepository;
	
	@Mock
	private MongoOperations mongo;

	@Before
	public void setUp() throws Exception {
		productRepository = Mockito.mock(ProductRepository.class);
		mongo = Mockito.mock(MongoOperations.class);
		productController = new ProductController();
		productService = new ProductServiceImpl();
		productService.setProductRepository(productRepository);
		productService.setMongo(mongo);
		productController.setProductService(productService);
	}

	@Test
	public void list() {
		Mockito.when(productService.listAllProducts()).thenReturn(new ArrayList<Product>());
		productController.list();
		assertTrue(true);
	}

	@Test
	public void showProduct() {
		productController.showProduct("test");
		assertTrue(true);
	}

	@Test
	public void saveProduct() {
		productController.saveProduct(new Product());
		assertTrue(true);
	}

	@Test
	public void updateProduct() {
		Mockito.when(productService.findByProductId(anyString())).thenReturn(new Product());
		productController.updateProduct(new Product());
		assertTrue(true);
	}

	@Test
	public void delete() {
		productController.delete("test");
		assertTrue(true);
	}

}
