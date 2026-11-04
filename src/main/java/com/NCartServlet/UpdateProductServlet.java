package com.NCartServlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.ProductBean;
import com.NCartDAO.UpdateProductDAO;
import com.NCart.Util.WebSecurity;

@WebServlet("/update")
public class UpdateProductServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		if (!WebSecurity.isAdmin(session)) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html");
			return;
		}
		if (!WebSecurity.isValidCsrfToken(session, req.getParameter("csrfToken"))) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		String code = req.getParameter("pcode");
		String price = req.getParameter("pPrice");
		String quantity = req.getParameter("pQty");
		ProductBean current = findProduct(session, code);
		if (current == null) {
			showResult(req, res, "Product was not found. Refresh the catalog and try again.");
			return;
		}

		BigDecimal amount;
		int stock;
		try {
			amount = new BigDecimal(price.trim());
			stock = Integer.parseInt(quantity.trim());
			if (amount.signum() < 0 || stock < 0) throw new IllegalArgumentException();
		} catch (RuntimeException e) {
			showResult(req, res, "Enter a valid non-negative price and whole-number quantity.");
			return;
		}

		ProductBean update = new ProductBean();
		update.setpCode(code);
		update.setpPrice(amount.toPlainString());
		update.setpQty(String.valueOf(stock));
		if (new UpdateProductDAO().updateProduct(update) > 0) {
			current.setpPrice(update.getpPrice());
			current.setpQty(update.getpQty());
			showResult(req, res, "Product updated.");
		} else {
			showResult(req, res, "Product was not updated. Refresh the catalog and try again.");
		}
	}

	private ProductBean findProduct(HttpSession session, String code) {
		ArrayList<ProductBean> products = (ArrayList<ProductBean>) session.getAttribute("productList");
		if (products == null || code == null) return null;
		for (ProductBean product : products) {
			if (code.equals(product.getpCode())) return product;
		}
		return null;
	}

	private void showResult(HttpServletRequest req, HttpServletResponse res, String message)
			throws ServletException, IOException {
		req.setAttribute("msg", message);
		req.getRequestDispatcher("UpdateProduct.jsp").forward(req, res);
	}
}