package com.practice.spring.ecom.datamanager.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.practice.spring.ecom.datamanager.models.PageDetails;
import com.practice.spring.ecom.datamanager.models.PagedProduct;
import com.practice.spring.ecom.datamanager.models.Product;
import com.practice.spring.ecom.datamanager.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
	
	@Override
	public PagedProduct getAllProductsByPage(Integer page, Integer numberOfRecords){
		Pageable pageable = PageRequest.of(page, numberOfRecords);
		Page<Product> product = productRepository.findAll(pageable);
		PageDetails pageDetails = getPageDeatils(product);
//		System.out.println("Page getSize: "+product.getSize());
//		System.out.println("Page getSize: "+product.isLast());
//		PagedProduct pagedProduct = new PagedProduct(pageDetails, product.getContent());
		return getPagedProduct(product, pageDetails);
	}

	@Override
	public Product addOrUpdateProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public PagedProduct getAllProductsByCategory(Integer page, Integer records, String category) {
		System.out.println("category: "+category);
		if(category.isEmpty()) {
			return getAllProductsByPage(page, records);
		}
		Pageable pageable = PageRequest.of(page, records);
		Page<Product> product = productRepository.findAllByCategoryContaining(category, pageable);
		PageDetails pageDetails = getPageDeatils(product);
//		System.out.println("Page getSize: "+product.getSize());
//		System.out.println("Page getSize: "+product.isLast());
		//PagedProduct pagedProduct = new PagedProduct(pageDetails, product.getContent());
		return getPagedProduct(product, pageDetails);
	}

	@Override
	public PagedProduct searchProductByKeyword(Integer page, Integer records, String keyword) {
		
		Page<Product> product = productRepository.findAllByKeyword(keyword, PageRequest.of(page, records));
		System.out.println("Page getSize: "+product.getNumber());
		PageDetails pageDetails = getPageDeatils(product);
		return getPagedProduct(product, pageDetails);
		
	}


	private PagedProduct getPagedProduct(Page<Product> product, PageDetails pageDetails) {
		return new PagedProduct(pageDetails, product.getContent());
	}

	private PageDetails getPageDeatils(Page<Product> product){
		return new PageDetails(product.getNumber()+1, product.getTotalPages(), product.getNumberOfElements(), product.hasNext());
	}

	@Override
	public PagedProduct searchProductByQuery(Integer page, Integer records, String keyword, String category) {
		
		if(category.isEmpty() && keyword.isEmpty()) {
			return getAllProductsByPage(page, records);
		}
		
		if(category.isEmpty()) {
			return searchProductByKeyword(page, records, keyword);
		}
		if(keyword.isEmpty()) {
			return getAllProductsByCategory(page,records,category);
		}
		Page<Product> product = productRepository.findAllByQuery(keyword, category, PageRequest.of(page, records));
		System.out.println("Page getSize: "+product.getNumber());
		PageDetails pageDetails = getPageDeatils(product);
		return getPagedProduct(product, pageDetails);
	}

}
