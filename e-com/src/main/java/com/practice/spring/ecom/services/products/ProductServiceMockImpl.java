package com.practice.spring.ecom.services.products;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.practice.spring.ecom.models.Product;

@Service
public class ProductServiceMockImpl implements ProductService {

	private Map<UUID, Product> products;

	public ProductServiceMockImpl() {
		loadProducts();
	}

	@Override
	public List<Product> getAllProducts() {
		return new ArrayList<Product>(products.values());
	}

	private void loadProducts() {
		products= new HashMap<>();
		
		//Product p1= new Product(101,"Product 1", new BigDecimal(12.99),"http://example.com/product1");
		UUID uuid = UUID.randomUUID();
		products.put(uuid, new Product(uuid,"Product 1", 12.99,"http://example.com/product1"));
		uuid = UUID.randomUUID();
		products.put(uuid, new Product(uuid,"Product 2", 13.99,"http://example.com/product2"));
		uuid = UUID.randomUUID();
		products.put(uuid, new Product(uuid,"Product 3", 14.99,"http://example.com/product3"));
		uuid = UUID.randomUUID();
		products.put(uuid, new Product(uuid,"Product 4", 15.99,"http://example.com/product4"));
		uuid = UUID.randomUUID();
		products.put(uuid, new Product(uuid,"Product 5", 16.99,"http://example.com/product5"));
	}

	@Override
	public Product getProductById(UUID id) {
		return products.get(id);
	}

	@Override
	public Product saveOrUpdateProduct(Product product) {
		if(product!=null) {
			if(product.getId()==null) {
				UUID uuid = UUID.randomUUID();
				product.setId(uuid);
				products.put(uuid, product);
			}
			else {
				products.put(product.getId(), product);
			}
			return product;
		}
		throw new RuntimeException("Product cannot be null");
	}

	@Override
	public void deleteProduct(UUID id) {
		products.remove(id);
	}

	@Override
	public List<Product> getProductsByPage(Integer page, Integer record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProductsByCategory(Integer page, Integer records, String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchProductsByKeyword(Integer page, Integer records, String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object searchProductsByKeyword(Integer page, Integer records, String keyword, String category) {
		// TODO Auto-generated method stub
		return null;
	}

}
