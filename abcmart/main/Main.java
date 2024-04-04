package com.abcmart.main;

import java.util.Scanner;

import com.abcmart.controller.OrderController;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter ProductId: ");
		int productId = sc.nextInt();
		
		System.out.println("Enter Quantity: ");
		int qty = sc.nextInt();
		
		sc.close();
		
		OrderController orderController = new OrderController();
		String msg = orderController.buyProduct(productId, qty);
		
		System.out.println(msg);

	}

}
