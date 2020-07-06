package com.swashtech.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.swashtech.product.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	
	Product findByproductId(String productId);
}
