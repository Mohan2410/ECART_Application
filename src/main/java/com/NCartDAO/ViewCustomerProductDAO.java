package com.NCartDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.NCart.Bean.ProductBean;

public class ViewCustomerProductDAO {
    public ArrayList<ProductBean> retriveCustomerProduct() {
        ArrayList<ProductBean> al = new ArrayList<>();
        try {
            Connection con = DBConnection.getCon();
            if (con == null) return null;
            try (PreparedStatement pstmt = con.prepareStatement("SELECT * FROM product");
                    ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ProductBean pb = new ProductBean();
                    pb.setpCode(rs.getString(1));
                    pb.setpName(rs.getString(2));
                    pb.setpComp(rs.getString(3));
                    pb.setpPrice(rs.getString(4));
                    pb.setpQty(rs.getString(5));
                    al.add(pb);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return al;
    }
}
