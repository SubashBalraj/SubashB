package com.abcmart.controller;

import java.util.List;

import com.abcmart.dto.Product;
import com.abcmart.service.ProductService;

public class ProductController {
	
	public void displayAllProducts() {
	ProductService productService = new ProductService();
	List<Product> products = productService.fetchAllProducts();
	
	products.forEach(p -> System.out.println(p.getProductId() + " " + p.getProductName() + " " + p.getProductPrice() + " " + p.getMfd() + " " + p.getCategory()));


 }
}

