package com.abcmart.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.abcmart.dto.Product;
import com.abcmart.util.DBUtil;

public class ProductDao {

	public Product findProduct(int productId) {
		Connection con = DBUtil.getOracleDBConnection();
		String sql = "Select * from product_tbl where product_id =?";
		Product product = null;
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int pId = rs.getInt(1);
				String pname = rs.getString(2);
				double pprice = rs.getDouble(3);
				Date mfd =rs.getDate(4);
				String category =rs.getString(5);
				
				product =new Product();
				product.setProductId(pId);
				product.setProductName(pname);
				product.setProductPrice(pprice);
				product.setMfd(mfd.toLocalDate());
				product.setCategory(category);
				}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
		}
		}
		return product;
	}
	public List<Product> findAllProducts() {
	    List<Product> products = new ArrayList<>();
	    String sql = "Select * from product_tbl";

	    try (Connection con = DBUtil.getOracleDBConnection();
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql);) {

	        while (rs.next()) {
	            int pId = rs.getInt(1);
	            String pname = rs.getString(2);
	            double pprice = rs.getDouble(3);
	            Date mfd = rs.getDate(4);
	            String category = rs.getString(5);

	            Product product = new Product();
	            product.setProductId(pId);
	            product.setProductName(pname);
	            product.setProductPrice(pprice);
	            product.setMfd(mfd.toLocalDate());
	            product.setCategory(category);

	            products.add(product);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return products;
	}
}

