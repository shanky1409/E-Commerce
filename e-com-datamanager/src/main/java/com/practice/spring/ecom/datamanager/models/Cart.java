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
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(columnDefinition = "char(36)", name = "id")
	@Type(type="uuid-char")
	private UUID id;

	private String email;

	private String productId;

	public Cart() {

	}

	public Cart(UUID id, String email, String productId) {
		this.id = id;
		this.email = email;
		this.productId = productId;
	}

	public Cart(String email, String productId) {
		this.email = email;
		this.productId = productId;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", email=" + email + ", productId=" + productId + "]";
	}

}
