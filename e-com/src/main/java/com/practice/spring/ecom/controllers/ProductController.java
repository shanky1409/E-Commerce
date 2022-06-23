package com.practice.spring.ecom.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.spring.ecom.models.Product;
import com.practice.spring.ecom.services.products.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService=productService;
	}
	
	@RequestMapping({"", "/list"})
	public String proucts(Model model){
		model.addAttribute("products", productService.getAllProducts());
		return "products/products";
	}
	
	@RequestMapping("/{id}")
	public String prouct(@PathVariable UUID id ,Model model){
		model.addAttribute("product", productService.getProductById(id));
		return "products/product";
	}
	
	@RequestMapping("/new")
	public String newProduct(Model model){
		model.addAttribute("product",new Product());
		return "products/productform";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdateProduct(Product product){
		Product savedProduct= productService.saveOrUpdateProduct(product);
		
		return "redirect:/product/"+savedProduct.getId();
	}
	
	@RequestMapping(path = "/edit/{id}")
	public String update(@PathVariable UUID id, Model model ){
		model.addAttribute("product", productService.getProductById(id));
		return "products/productform";
	}
	
	@RequestMapping(path = "/delete/{id}")
	public String delete(@PathVariable UUID id){
		productService.deleteProduct(id);
		return "redirect:/product";
	}
	

}
