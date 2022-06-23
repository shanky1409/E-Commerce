package com.practice.spring.ecom.datamanager.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.spring.ecom.datamanager.models.Cart;
import com.practice.spring.ecom.datamanager.models.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, UUID> {
	public void deleteByEmail(String email);
	
	@Query("Select c.productId from Cart c where email=?1")
	public List<String> findProductIdByEmail(String email);

	@Query( value = "select p from Product p, Cart c where c.productId in ?1 and c.productId=p.id" )
	public List<Product> findAllProductsById(List<String> productIds);
}
