package com.practice.spring.ecom.datamanager.services;

import java.util.List;

import com.practice.spring.ecom.datamanager.models.PagedProduct;
import com.practice.spring.ecom.datamanager.models.Product;

public interface ProductService {

	public List<Product> getAllProducts();
	
	public PagedProduct getAllProductsByPage(Integer page, Integer numberOfRecords);
	
	public Product addOrUpdateProduct(Product product);

	public PagedProduct getAllProductsByCategory(Integer page, Integer records, String category);

	public PagedProduct searchProductByKeyword(Integer page, Integer records, String keyword);

	public PagedProduct searchProductByQuery(Integer page, Integer records, String keyword, String category);
}
