package com.deneme.demo.Entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "products")
class Product {
	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long product_id
	
	@Column(name = "product_name")
	private String product_name

	@Column(name = "product_stock")
	private long product_stock
	
	@Column(name = "brand")
	private String brand
	
	@Column(name = "category")
	private String category
	
	@Column(name = "made_in")
	private String madeIn
	
	@Column(name = "price")
	private double price

	long getProduct_id() {
		return product_id
	}

	void setProduct_id(long product_id) {
		this.product_id = product_id
	}

	long getProduct_stock() {
		return product_stock
	}

	void setProduct_stock(long product_stock) {
		this.product_stock = product_stock
	}
	
	String getProduct_name() {
		return product_name
	}

	void setProduct_name(String product_name) {
		this.product_name = product_name
	}

	String getBrand() {
		return brand
	}

	void setBrand(String brand) {
		this.brand = brand
	}

	String getCategory() {
		return category
	}

	void setCategory(String category) {
		this.category = category
	}

	String getMadeIn() {
		return madeIn
	}

	void setMadeIn(String madeIn) {
		this.madeIn = madeIn
	}

	double getPrice() {
		return price
	}

	void setPrice(double price) {
		this.price = price
	}
	
	
}
