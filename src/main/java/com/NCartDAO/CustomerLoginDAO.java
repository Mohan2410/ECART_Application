package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.NCart.Bean.CustomerBean;

public class CustomerLoginDAO {
	public CustomerBean checkCustomerLogin(String username, String password) {
		CustomerBean cbean = null;
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement pstmt = con.prepareStatement("select * from customer1 where uname = ? and pword = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cbean = new CustomerBean();
				cbean.setCuname(rs.getString(1));
				cbean.setCpwd(rs.getString(2));
				cbean.setCfname(rs.getString(3));
				cbean.setClname(rs.getString(4));
				cbean.setCaddr(rs.getString(5));
				cbean.setCmailid(rs.getString(6));
				cbean.setCmobile(rs.getString(7));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cbean;
	}

}
