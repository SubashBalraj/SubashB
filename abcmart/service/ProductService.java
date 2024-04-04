package com.abcmart.service;

import java.util.List;

import com.abcmart.dao.ProductDao;
import com.abcmart.dto.Product;

public class ProductService {
	public List<Product>fetchAllProducts() {
		ProductDao productdao = new ProductDao();
		List<Product> productList = productdao.findAllProducts();
		return productList;
	}

}

