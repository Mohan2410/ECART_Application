package com.NCart.Util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

import javax.servlet.http.HttpSession;

import com.NCart.Bean.AdminBean;
import com.NCart.Bean.CustomerBean;

public final class WebSecurity {
	private static final String CSRF_SESSION_KEY = "csrfToken";
	private static final SecureRandom RANDOM = new SecureRandom();

	private WebSecurity() {
	}

	public static boolean isAdmin(HttpSession session) {
		return session != null && session.getAttribute("abean") instanceof AdminBean;
	}

	public static boolean isCustomer(HttpSession session) {
		return session != null && session.getAttribute("cbean") instanceof CustomerBean;
	}

	public static String csrfToken(HttpSession session) {
		String token = (String) session.getAttribute(CSRF_SESSION_KEY);
		if (token == null) {
			byte[] bytes = new byte[32];
			RANDOM.nextBytes(bytes);
			token = Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
			session.setAttribute(CSRF_SESSION_KEY, token);
		}
		return token;
	}

	public static boolean isValidCsrfToken(HttpSession session, String submittedToken) {
		if (session == null || submittedToken == null) return false;
		String expectedToken = (String) session.getAttribute(CSRF_SESSION_KEY);
		return expectedToken != null && MessageDigest.isEqual(
				expectedToken.getBytes(java.nio.charset.StandardCharsets.UTF_8),
				submittedToken.getBytes(java.nio.charset.StandardCharsets.UTF_8));
	}
}