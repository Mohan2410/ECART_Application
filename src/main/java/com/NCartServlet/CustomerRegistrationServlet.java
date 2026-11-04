package com.NCartServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.CustomerBean;
import com.NCartDAO.CustomerRegisterDAO;

@WebServlet("/crs")
public class CustomerRegistrationServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
			CustomerBean cb = new CustomerBean();
			String username = req.getParameter("cuname");
			String password = req.getParameter("cpwd");
			String firstName = req.getParameter("cfname");
			String lastName = req.getParameter("clname");
			String address = req.getParameter("caddr");
			String email = req.getParameter("cmailid");
			String mobile = req.getParameter("cmobile");
			if (isBlank(username) || isBlank(password) || isBlank(firstName) || isBlank(lastName)
					|| isBlank(address) || isBlank(email) || isBlank(mobile)) {
				res.sendRedirect(req.getContextPath() + "/CustomerRegister.html?error=required");
				return;
			}
			String passwordError = passwordValidationError(password);
			if (passwordError != null) {
				res.sendRedirect(req.getContextPath() + "/CustomerRegister.html?error=" + passwordError);
				return;
			}
			if (!email.trim().matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
				res.sendRedirect(req.getContextPath() + "/CustomerRegister.html?error=email");
				return;
			}
			if (!mobile.matches("^[0-9]{10}$")) {
				res.sendRedirect(req.getContextPath() + "/CustomerRegister.html?error=mobile");
				return;
			}
			cb.setCuname(username.trim());
			cb.setCpwd(req.getParameter("cpwd"));
			cb.setCfname(firstName.trim());
			cb.setClname(lastName.trim());
			cb.setCaddr(address.trim());
			cb.setCmailid(email.trim());
			cb.setCmobile(mobile.trim());
			
			int rowCount = new CustomerRegisterDAO().checkCustomerRegistration(cb);

			if (rowCount > 0) {
			    HttpSession previousSession = req.getSession(false);
			    if (previousSession != null) previousSession.invalidate();
			    cb.setCpwd(null);
			    HttpSession session = req.getSession(true);
			    session.setAttribute("cbean", cb);
			    res.sendRedirect(req.getContextPath() + "/CustomerHome.jsp?registered=1");

			} else if (rowCount == -1) {
			    res.sendRedirect(req.getContextPath() + "/CustomerRegister.html?duplicate=1");
			} else {
			    res.sendRedirect(req.getContextPath() + "/CustomerRegister.html?error=1");
			}
	}

	private boolean isBlank(String value) {
		return value == null || value.trim().isEmpty();
	}

	private String passwordValidationError(String password) {
		if (password.length() < 8) return "password-length";
		if (!password.matches("(?s).*?[A-Z].*")) return "password-uppercase";
		if (!password.matches("(?s).*?[^A-Za-z0-9\\s].*")) return "password-special";
		if (!password.matches("\\S+")) return "password-space";
		if (!password.matches("^(?=.*[A-Z])(?=.*[^A-Za-z0-9\\s])\\S{8,}$")) return "password-length";
		return null;
	}

}
