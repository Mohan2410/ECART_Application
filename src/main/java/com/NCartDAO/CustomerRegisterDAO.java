package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.NCart.Bean.CustomerBean;

public class CustomerRegisterDAO {
	public int checkCustomerRegistration(CustomerBean cb) {
		int rowCount = 0;
		try {
			Connection con = DBConnection.getCon();
			if (con == null) return 0;
			try (PreparedStatement duplicateCheck = con.prepareStatement(
					"select 1 from customer1 where uname = ?")) {
				duplicateCheck.setString(1, cb.getCuname());
				try (java.sql.ResultSet result = duplicateCheck.executeQuery()) {
					if (result.next()) return -1;
				}
			}
			try (PreparedStatement pstmt = con.prepareStatement("insert into customer1 values(?,?,?,?,?,?,?)")) {
				pstmt.setString(1, cb.getCuname());
				pstmt.setString(2, cb.getCpwd());
				pstmt.setString(3, cb.getCfname());
				pstmt.setString(4, cb.getClname());
				pstmt.setString(5, cb.getCaddr());
				pstmt.setString(6, cb.getCmailid());
				pstmt.setString(7, cb.getCmobile());
				rowCount = pstmt.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}
}
