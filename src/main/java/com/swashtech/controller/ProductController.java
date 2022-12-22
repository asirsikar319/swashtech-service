package com.swashtech.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swashtech.product.domain.Product;
import com.swashtech.services.ProductService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/swashtech/product")
public class ProductController {

	Logger logger = LoggerFactory.getLogger(ProductController.class);

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Product> list() {
		List<Product> productList = productService.listAllProducts();
		logger.debug("Product List : {}", productList.toString());
		return productList;
	}

	@ApiOperation(value = "Search a product with an ID")
	@RequestMapping(value = "/show/{productId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Product> showProduct(@PathVariable String productId) {
		logger.debug("Find Product by ProductId : {}", productId);
		Product product = productService.findByProductId(productId);
		logger.info("Product Found by ProductId : {}", productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		logger.debug("Product to Insert : {}", product.toString());
		Product dBProduct = productService.saveProduct(product);
		logger.info("Product {} Inserted Successfully", dBProduct.getProductId());
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		logger.debug("Product to Update : {}", product.toString());
		Product storedProduct = productService.findByProductId(product.getProductId());
		storedProduct.setDescription(product.getDescription());
		storedProduct.setImageUrl(product.getImageUrl());
		storedProduct.setPrice(product.getPrice());
		productService.updateProduct(storedProduct);
		logger.info("Product {} Updated Successfully", storedProduct.getProductId());
		return new ResponseEntity<Product>(storedProduct, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Product> delete(@PathVariable String id) {
		logger.debug("ProductId to Delete : {}", id);
		productService.deleteProduct(id);
		logger.info("Product {} Deleted Successfully", id);
		return new ResponseEntity<Product>(HttpStatus.OK);

	}

}
