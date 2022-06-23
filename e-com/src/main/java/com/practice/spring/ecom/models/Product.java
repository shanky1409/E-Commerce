package com.practice.spring.ecom.models;

import java.util.UUID;

public class Product {
	private UUID id;
	private String name;
	private String category;
	private String description;
	private double price;
	private String imageUrl;

	public Product() {

	}

	public Product(UUID id, String description, double price, String imageUrl) {
		this.id = id;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public Product(UUID id, String name, String category, String description, double price, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
