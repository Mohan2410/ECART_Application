package com.NCartServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.NCart.Bean.AdminBean;
import com.NCart.Bean.CustomerBean;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String logoutRole = null;
		String logoutName = null;
		if (session != null) {
			Object admin = session.getAttribute("abean");
			Object customer = session.getAttribute("cbean");
			if (admin instanceof AdminBean) {
				String firstName = ((AdminBean) admin).getaFNAME();
				if (firstName != null && !firstName.trim().isEmpty()) {
					logoutRole = "Admin";
					logoutName = firstName.trim();
				}
			} else if (customer instanceof CustomerBean) {
				String firstName = ((CustomerBean) customer).getCfname();
				if (firstName != null && !firstName.trim().isEmpty()) {
					logoutRole = "Customer";
					logoutName = firstName.trim();
				}
			}
			session.invalidate();
		}
		req.setAttribute("logoutRole", logoutRole);
		req.setAttribute("logoutName", logoutName);
		req.getRequestDispatcher("/Logout.jsp").forward(req, res);
	}

}
