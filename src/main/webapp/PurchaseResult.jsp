<%@page import="com.NCart.Bean.CustomerBean,com.NCart.Util.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Purchase status | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<% CustomerBean customer = (CustomerBean) session.getAttribute("cbean"); if (customer == null) { response.sendRedirect(request.getContextPath() + "/CustomerLogin.html"); return; } String message = (String) request.getAttribute("msg"); %>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-16"><section class="mx-auto max-w-xl rounded-xl border border-line bg-white p-7 shadow-sm sm:p-9"><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-coral"><i class="bi bi-exclamation-circle mr-1" aria-hidden="true"></i>Purchase status</p><h1 class="font-display text-3xl font-normal">We could not complete that purchase.</h1><p class="notice notice-error mt-5" role="alert"><i class="bi bi-exclamation-circle mr-2" aria-hidden="true"></i><%=Html.escape(message == null ? "Please review the product and quantity, then try again." : message)%></p><div class="mt-7 flex flex-wrap gap-3"><a class="button-primary" href="<%=request.getContextPath()%>/view"><i class="bi bi-box-seam mr-2" aria-hidden="true"></i>Return to products</a><a class="button-secondary" href="<%=request.getContextPath()%>/CustomerHome.jsp"><i class="bi bi-person-circle mr-2" aria-hidden="true"></i>My account</a></div></section></main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>