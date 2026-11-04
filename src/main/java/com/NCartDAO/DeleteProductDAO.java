package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.NCart.Bean.ProductBean;

public class DeleteProductDAO {
	public int deleteProduct(String pCode) {
		int rowCount = 0;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement("delete from product where pcode = ?");
			
			pstmt.setString(1, pCode);
			rowCount = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
		
	}
}
