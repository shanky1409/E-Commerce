package com.practice.spring.ecom.datamanager.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name ="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "char(36)", name = "id")
	@Type(type="uuid-char")
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
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
	}
	
	public Product(String name, String category, String description, double price, String imageUrl) {
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.imageUrl = imageUrl;
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
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + ", imageUrl=" + imageUrl + "]";
	}
	
	
}
