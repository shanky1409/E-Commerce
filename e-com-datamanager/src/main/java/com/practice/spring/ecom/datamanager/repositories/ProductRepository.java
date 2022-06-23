package com.practice.spring.ecom.datamanager.repositories;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.practice.spring.ecom.datamanager.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
	Page<Product> findAllByCategoryContaining(String category, Pageable pageable);
	
	@Query(" SELECT p FROM Product p where p.name LIKE %?1% OR p.category LIKE %?1% OR p.description LIKE %?1% ")
	Page<Product> findAllByKeyword(String keyword, Pageable pageable);
	
	@Query(" SELECT p FROM Product p where  p.category =?2 AND (p.name LIKE %?1% OR p.description LIKE %?1%)")
	Page<Product> findAllByQuery(String keyword,String category, Pageable pageable);
}
