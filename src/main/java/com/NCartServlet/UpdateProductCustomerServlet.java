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

import com.NCart.Bean.CustomerBean;
import com.NCart.Bean.ProductBean;
import com.NCartDAO.UpdateProductServletDAO;
import com.NCartDAO.ViewCustomerProductDAO;
import com.NCart.Util.WebSecurity;

@WebServlet("/confirmPurchase")
public class UpdateProductCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession(false);
		if (!WebSecurity.isCustomer(session)) {
			res.sendRedirect(req.getContextPath() + "/CustomerLogin.html");
			return;
		}
		if (!WebSecurity.isValidCsrfToken(session, req.getParameter("csrfToken"))) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}

		String code = req.getParameter("pcode");
		int quantity;
		try {
			if (code == null || code.trim().isEmpty()) throw new IllegalArgumentException();
			quantity = Integer.parseInt(req.getParameter("pqty"));
			if (quantity <= 0) throw new IllegalArgumentException();
		} catch (RuntimeException e) {
			showFailure(req, res, "Enter a valid product and a quantity greater than zero.");
			return;
		}

		ArrayList<ProductBean> currentProducts = new ViewCustomerProductDAO().retriveCustomerProduct();
		if (currentProducts == null) {
			showFailure(req, res, "The catalog is temporarily unavailable. Please try again.");
			return;
		}
		ProductBean product = null;
		for (ProductBean candidate : currentProducts) {
			if (code.equals(candidate.getpCode())) {
				product = candidate;
				break;
			}
		}
		if (product == null) {
			showFailure(req, res, "This product is no longer available in the catalog.");
			return;
		}

		int available;
		BigDecimal price;
		try {
			available = Integer.parseInt(product.getpQty());
			price = new BigDecimal(product.getpPrice());
			if (available < 0 || price.signum() < 0) throw new IllegalArgumentException();
		} catch (RuntimeException e) {
			showFailure(req, res, "The product has invalid price or inventory data. Please contact the store administrator.");
			return;
		}
		if (quantity > available) {
			showFailure(req, res, "There is not enough stock to complete this purchase.");
			return;
		}

		BigDecimal total = price.multiply(BigDecimal.valueOf(quantity));
		if (new UpdateProductServletDAO().buyProductUpdate(product, quantity) <= 0) {
			showFailure(req, res, "The product price or stock changed. Refresh the catalog and try again.");
			return;
		}

		product.setpQty(String.valueOf(available - quantity));
		session.setAttribute("productList", currentProducts);
		req.setAttribute("productBean", product);
		req.setAttribute("quantity", quantity);
		req.setAttribute("totalAmount", total);
		req.getRequestDispatcher("/OrderConfirmed.jsp").forward(req, res);
	}

	private void showFailure(HttpServletRequest req, HttpServletResponse res, String message)
			throws ServletException, IOException {
		req.setAttribute("msg", message);
		req.getRequestDispatcher("/PurchaseResult.jsp").forward(req, res);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}
}