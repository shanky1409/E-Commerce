package com.practice.spring.ecom.services.products;

import java.util.List;
import java.util.UUID;

import com.practice.spring.ecom.models.Product;

public interface ProductService {
	public List<Product> getAllProducts();
	
	public Product getProductById(UUID id);
	
	public Product saveOrUpdateProduct(Product product);
	
	public void deleteProduct(UUID id);
	
	public Object getProductsByPage(Integer page, Integer record);

	public Object getProductsByCategory(Integer page, Integer records, String category);

	public Object searchProductsByKeyword(Integer page, Integer records, String keyword);

	public Object searchProductsByKeyword(Integer page, Integer records, String keyword, String category);
}
