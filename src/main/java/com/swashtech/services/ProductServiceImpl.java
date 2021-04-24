package com.swashtech.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.DBObject;
import com.swashtech.product.domain.Product;
import com.swashtech.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	private ProductRepository productRepository;

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	private MongoOperations mongo;
	
	public void setMongo(MongoOperations mongo) {
		this.mongo = mongo;
	}

	@Override
	public List<Product> listAllProducts() {
		logger.debug("listAllProducts called");
		return productRepository.findAll();
	}

	@Override
	public Product findByProductId(String productId) {
		logger.debug("getProductById called");
		Product dBProduct = productRepository.findByproductId(productId);
		return dBProduct;
	}

	@Override
	public Product saveProduct(Product product) {
		logger.debug("saveProduct called");
		Product dBProduct = productRepository.insert(product);
		return dBProduct;
	}

	@Override
	public void deleteProduct(String productId) {
		logger.debug("deleteProduct called");
		Product dBProduct = productRepository.findByproductId(productId);
		productRepository.delete(dBProduct);
	}

	@Override
	public Product updateProduct(Product product) {
		logger.debug("saveProduct called");
		Product dBProduct = productRepository.save(product);
		return dBProduct;
	}

}
