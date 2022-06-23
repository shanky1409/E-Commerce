package com.practice.spring.ecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.ecom.models.Product;
import com.practice.spring.ecom.services.products.ProductService;

@RestController
@RequestMapping("/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@RequestMapping({"","/list"})
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/get-by-page")
	public Object getAllProductsByPage(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records){
		return productService.getProductsByPage(page, records);
	}
	
	@RequestMapping("/get-by-category")
	public Object getAllProductsByPage(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records, @RequestParam(name = "category") String category){
		return productService.getProductsByCategory(page, records,category);
	}
	
	@RequestMapping("/search")
	public Object searchProductsByKeyword(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records, @RequestParam("keyword") String keyword){
		return productService.searchProductsByKeyword(page, records,keyword);
	}
	@RequestMapping("/search-all")
	public Object searchProductsByQuery(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records, @RequestParam(name = "category") String category, @RequestParam("keyword") String keyword){
		return productService.searchProductsByKeyword(page, records,keyword,category);
	}
	
}
