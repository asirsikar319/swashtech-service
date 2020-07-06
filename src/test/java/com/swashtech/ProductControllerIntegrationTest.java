package com.swashtech;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.swashtech.controller.ProductController;
import com.swashtech.product.domain.Product;
import com.swashtech.services.ProductService;

@WebMvcTest(value = ProductController.class, secure = false)
@ComponentScan("com.swashtech")
@EnableMongoRepositories(basePackages = "com.swashtech.repositories")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductControllerIntegrationTest {

	@Autowired
	private ProductService productService;

	@Test
	public void listAllProducts() throws Exception {
		List<Product> list = productService.listAllProducts();
		System.out.println(list);
		assertTrue(list.size() != 0);
	}

	@Test
	public void saveProduct() throws Exception {
		Product product = new Product();
		product.setId(2);
		product.setProductId("222");
		product.setDescription("test");
		product.setImageUrl("img/test.png");
		product.setPrice(BigDecimal.TEN);
		product = productService.saveProduct(product);
		assertTrue(product != null);
	}

	@Test
	public void updateProduct() throws Exception {
		Product product = new Product();
		product.setId(2);
		product.setProductId("222");
		product.setDescription("test123");
		product.setImageUrl("img/test.png");
		product.setPrice(BigDecimal.TEN);
		product = productService.updateProduct(product);
		assertTrue(product != null);
	}

	@Test
	public void findByProductId() throws Exception {
		Product product = productService.findByProductId("12345");
		assertTrue(product != null);
	}

	@Test
	public void deleteProduct() throws Exception {
		productService.deleteProduct("222");
		assertTrue(true);
	}

}
