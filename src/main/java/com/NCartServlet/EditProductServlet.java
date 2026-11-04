package com.NCartServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.ProductBean;
import com.NCart.Util.WebSecurity;

@WebServlet("/edit")
public class EditProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(!WebSecurity.isAdmin(session)) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html");
			return;
		}else {
			String pCode = req.getParameter("pcode");
			ProductBean pb = null;
			ArrayList<ProductBean> al = (ArrayList<ProductBean>)session.getAttribute("productList");
			if (al != null && pCode != null) {
				Iterator<ProductBean> i = al.iterator();
				while(i.hasNext()) {
					ProductBean candidate = i.next();
					if(pCode.equals(candidate.getpCode())) {
						pb = candidate;
						break;
					}
				}
			}
			if (pb == null) {
				res.sendRedirect(req.getContextPath() + "/view1");
				return;
			}
			req.setAttribute("productBean", pb);
			req.getRequestDispatcher("EditProduct.jsp").forward(req, res);
		
		}
	}

}
