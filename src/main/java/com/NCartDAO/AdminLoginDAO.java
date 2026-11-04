package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.NCart.Bean.AdminBean;

public class AdminLoginDAO {
	public AdminBean checkAdminLogin(String username,String password) {
		AdminBean abean = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM admin WHERE uname = ? AND pword = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				abean = new AdminBean();
				
				abean.setaUNAME(rs.getString(1));
				abean.setaPWORD(rs.getString(2));
				abean.setaFNAME(rs.getString(3));
				abean.setaLNAME(rs.getString(4));
				abean.setaADDR(rs.getString(5));
				abean.setaMID(rs.getString(6));
				abean.setaPHNO(rs.getString(7));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return abean;
	}
}
