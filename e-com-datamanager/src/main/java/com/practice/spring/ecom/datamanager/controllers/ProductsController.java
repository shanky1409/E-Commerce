package com.practice.spring.ecom.datamanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.ecom.datamanager.models.PagedProduct;
import com.practice.spring.ecom.datamanager.models.Product;
import com.practice.spring.ecom.datamanager.services.ProductService;

@RestController
@RequestMapping("/data/products")
public class ProductsController {

	ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		this.productService = productService;
	}
	
	@RequestMapping({"","/list"})
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping("/get-by-page")
	public PagedProduct getProductsByPage(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records){
		return productService.getAllProductsByPage(page, records);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Product addOrUpdateProduct(@RequestBody Product product) {
		return productService.addOrUpdateProduct(product);
	}
	
	@RequestMapping("/get-by-category")
	public PagedProduct getProductsByCategory(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records, @RequestParam("category") String category){
		return productService.getAllProductsByCategory(page, records, category);
	}
	
	@RequestMapping("/search")
	public PagedProduct searchProductsByKeyword(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records, @RequestParam("keyword") String keyword){
		return productService.searchProductByKeyword(page, records, keyword);
	}
	@RequestMapping("/search-all")
	public PagedProduct searchProductsByQuery(@RequestParam(name = "page") Integer page, @RequestParam("records") Integer records, @RequestParam("keyword") String keyword, @RequestParam("category") String category){
		return productService.searchProductByQuery(page, records, keyword,category);
	}
	
}
