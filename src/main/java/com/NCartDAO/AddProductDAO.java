package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.NCart.Bean.ProductBean;

public class AddProductDAO {
	public int addProduct(ProductBean pb) {
		int rowCount = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?,?,?)");
			
			pstmt.setString(1, pb.getpCode());
			pstmt.setString(2, pb.getpName());
			pstmt.setString(3, pb.getpComp());
			pstmt.setString(4, pb.getpPrice());
			pstmt.setString(5, pb.getpQty());
			
			rowCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount; 
	}
}
