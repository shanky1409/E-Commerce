package com.practice.spring.ecom.datamanager.models;

import java.util.List;

public class PagedProduct {
	
	private PageDetails pageDetails;
	
	private List<Product> products;
	
	public PagedProduct(PageDetails pageDetails, List<Product> products) {
		super();
		this.pageDetails = pageDetails;
		this.products = products;
	}

	public PageDetails getPageDetails() {
		return pageDetails;
	}

	public void setPageDetails(PageDetails pageDetails) {
		this.pageDetails = pageDetails;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "PagedProduct [pageDetails=" + pageDetails + ", products=" + products + "]";
	}

	
	
	

}
