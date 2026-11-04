package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.NCart.Bean.ProductBean;

public class UpdateProductDAO {
	public int updateProduct(ProductBean pb) {
		int rowCount = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement("UPDATE product SET price=?, pqty=? WHERE pcode=?");
			
			pstmt.setString(1, pb.getpPrice());
			pstmt.setString(2, pb.getpQty());
			pstmt.setString(3, pb.getpCode());
			rowCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

}