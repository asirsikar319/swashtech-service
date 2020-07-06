package com.swashtech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swashtech.product.domain.Product;
import com.swashtech.services.ProductService;
import com.swashtech.services.ProductServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/swashtech/product")
public class ProductController {

	private ProductService productService;

	@Autowired
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@ApiOperation(value = "View a list of available products", response = Iterable.class)
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
	public List<Product> list() {
		List<Product> productList = productService.listAllProducts();
		return productList;
	}

	@ApiOperation(value = "Search a product with an ID")
	@RequestMapping(value = "/show/{productId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Product> showProduct(@PathVariable String productId) {
		Product product = productService.findByProductId(productId);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@ApiOperation(value = "Add a product")
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@ApiOperation(value = "Update a product")
	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product storedProduct = productService.findByProductId(product.getProductId());
		storedProduct.setDescription(product.getDescription());
		storedProduct.setImageUrl(product.getImageUrl());
		storedProduct.setPrice(product.getPrice());
		productService.updateProduct(storedProduct);
		return new ResponseEntity<Product>(storedProduct, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a product")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
	public ResponseEntity<Product> delete(@PathVariable String id) {
		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.OK);

	}

}
