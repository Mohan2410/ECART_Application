package com.NCartServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCartDAO.DeleteProductDAO;
import com.NCart.Util.WebSecurity;

@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(!WebSecurity.isAdmin(session)) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html");
			return;
		}
		if (!WebSecurity.isValidCsrfToken(session, req.getParameter("csrfToken"))) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		} else {
			String pCode = req.getParameter("pcode");
			if (pCode == null || pCode.trim().isEmpty()) {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			int rowCount = new DeleteProductDAO().deleteProduct(pCode);
			session.setAttribute("productActionMessage", rowCount > 0 ? "Product deleted." : "Product was not deleted; it may no longer exist.");
			res.sendRedirect(req.getContextPath() + "/view1");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
	}

}
