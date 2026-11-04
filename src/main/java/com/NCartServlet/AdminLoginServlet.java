package com.NCartServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.AdminBean;
import com.NCartDAO.AdminLoginDAO;

@WebServlet("/alog")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("aname");
		String password = req.getParameter("apwd");
		if (username == null || username.trim().isEmpty() || password == null || password.isEmpty()) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html?error=1");
			return;
		}
		AdminBean abean = new AdminLoginDAO().checkAdminLogin(username.trim(), password);
		
		if(abean == null) {
			res.sendRedirect(req.getContextPath() + "/AdminLogin.html?error=1");
		}else {
			HttpSession previousSession = req.getSession(false);
			if (previousSession != null) previousSession.invalidate();
			abean.setaPWORD(null);
			HttpSession session = req.getSession(true);
			session.setAttribute("abean", abean);
			res.sendRedirect(req.getContextPath() + "/AdminHome.jsp");
		}
	}

}
