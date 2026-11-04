package com.NCartServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.CustomerBean;
import com.NCartDAO.CustomerLoginDAO;

@WebServlet("/cls")
public class CustomerLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("cname");
		String password = req.getParameter("cpwd");
		if (username == null || username.trim().isEmpty() || password == null || password.isEmpty()) {
			res.sendRedirect(req.getContextPath() + "/CustomerLogin.html?error=1");
			return;
		}
		CustomerBean cbean = new CustomerLoginDAO().checkCustomerLogin(username.trim(), password);
		
		if(cbean == null) {
			res.sendRedirect(req.getContextPath() + "/CustomerLogin.html?error=1");
		}else {
			HttpSession previousSession = req.getSession(false);
			if (previousSession != null) previousSession.invalidate();
			cbean.setCpwd(null);
			HttpSession session = req.getSession(true);
			session.setAttribute("cbean", cbean);
			res.sendRedirect(req.getContextPath() + "/CustomerHome.jsp");
		}
	}

}
