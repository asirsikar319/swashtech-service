package com.swashtech.product.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "product")
public class Product {
	@Id
	@ApiModelProperty(notes = "The database generated product ID")
	private Integer id;
	@ApiModelProperty(notes = "The application-specific product ID")
	private String productId;
	@ApiModelProperty(notes = "The product description")
	private String description;
	@ApiModelProperty(notes = "The image URL of the product")
	private String imageUrl;
	@ApiModelProperty(notes = "The price of the product", required = true)
	private BigDecimal price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	
}
