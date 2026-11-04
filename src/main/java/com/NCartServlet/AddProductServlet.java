package com.NCartServlet;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.ProductBean;
import com.NCartDAO.AddProductDAO;
import com.NCart.Util.WebSecurity;

@WebServlet("/pls")
public class AddProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (!WebSecurity.isAdmin(session)) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html");
			return;
		}
		req.getRequestDispatcher("/AddProductForm.jsp").forward(req, res);
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		if(!WebSecurity.isAdmin(session)) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html");
			return;
		}else {
			if (!WebSecurity.isValidCsrfToken(session, req.getParameter("csrfToken"))) {
				res.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			ProductBean pb = new ProductBean();
			String pCode = req.getParameter("pCode");
			String pName = req.getParameter("pName");
			String pComp = req.getParameter("pComp");
			String pPrice = req.getParameter("pPrice");
			String pQty = req.getParameter("pQty");
			try {
				if (isBlank(pCode) || isBlank(pName) || isBlank(pComp) || isBlank(pPrice) || isBlank(pQty)
						|| new BigDecimal(pPrice.trim()).signum() < 0 || Integer.parseInt(pQty.trim()) < 0) {
					throw new IllegalArgumentException();
				}
			} catch (RuntimeException e) {
				req.setAttribute("msg", "Enter all product details with a valid non-negative price and quantity.");
				req.getRequestDispatcher("AddProductForm.jsp").forward(req, res);
				return;
			}
			pb.setpCode(pCode.trim());
			pb.setpName(pName.trim());
			pb.setpComp(pComp.trim());
			pb.setpPrice(new BigDecimal(pPrice.trim()).toPlainString());
			pb.setpQty(pQty.trim());
			
			int rowCount = new AddProductDAO().addProduct(pb);
			
			if(rowCount > 0) {
				req.setAttribute("msg", "Product Data Inserted!");
				req.getRequestDispatcher("AddProduct.jsp").forward(req, res);
			}else {
				req.setAttribute("msg", "Product could not be added. Check the product code and try again.");
				req.getRequestDispatcher("AddProductForm.jsp").forward(req, res);
			}
		}
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

}
