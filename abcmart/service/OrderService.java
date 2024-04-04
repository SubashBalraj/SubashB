package com.abcmart.service;
import com.abcmart.dao.ProductDao;
import com.abcmart.dto.Product;
public class OrderService {
	public double placeOrder(int productId, int quantity) {
		
		ProductDao productDao = new ProductDao();
		Product product = productDao.findProduct(productId);
		
		double productPrice = product.getProductPrice();
		double total = productPrice*quantity;
		double orderAmount = total+(total*0.05);
		
		return orderAmount;
		
	}

}
