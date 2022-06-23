package com.practice.spring.ecom.services.products;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.practice.spring.ecom.models.Product;
import com.practice.spring.ecom.utils.EComUtils;
import com.practice.spring.ecom.utils.RestClient;

@Service
@Primary
public class ProductsServiceDbImpl implements ProductService {

	private RestClient restClient;
	private EComUtils<Product> ecomUtils;
	
	@Autowired
	public ProductsServiceDbImpl(RestClient restClient, EComUtils<Product> ecomUtils) {
		super();
		this.restClient = restClient;
		this.ecomUtils = ecomUtils;
	}

	@Override
	public List<Product> getAllProducts() {
		String response= restClient.get("/data/products");
		return new Gson().fromJson(response, List.class);
	}

	@Override
	public Product getProductById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getProductsByPage(Integer page, Integer records) {
		String response= restClient.get("/data/products/get-by-page?page="+page+"&records="+records);
		return new Gson().fromJson(response, Object.class);
	}

	@Override
	public Object getProductsByCategory(Integer page, Integer records, String category) {
		String response= restClient.get("/data/products/get-by-category?page="+page+"&records="+records+"&category="+category);
		return new Gson().fromJson(response, Object.class);
	}

	@Override
	public Object searchProductsByKeyword(Integer page, Integer records, String keyword) {
		String response= restClient.get("/data/products/search?page="+page+"&records="+records+"&keyword="+keyword);
		return new Gson().fromJson(response, Object.class);
	}

	@Override
	public Object searchProductsByKeyword(Integer page, Integer records, String keyword, String category) {
		String response= restClient.get("/data/products/search-all?page="+page+"&records="+records+"&category="+category+"&keyword="+keyword);
		return new Gson().fromJson(response, Object.class);
	}

}
