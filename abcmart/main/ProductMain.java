package com.abcmart.main;

import com.abcmart.controller.ProductController;

public class ProductMain {

	public static void main(String[] args) {
		
		System.out.println("Display All products from store");
		
		ProductController pController = new ProductController();
		pController.displayAllProducts();

	}

}
