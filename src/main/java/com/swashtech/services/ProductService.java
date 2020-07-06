package com.swashtech.services;

import java.util.List;

import com.swashtech.product.domain.Product;

public interface ProductService {
	List<Product> listAllProducts();

	Product findByProductId(String productId);

	Product saveProduct(Product product);

	Product updateProduct(Product product);

	void deleteProduct(String productId);
}
