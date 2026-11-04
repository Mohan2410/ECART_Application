<%@page import="com.NCart.Bean.AdminBean,com.NCart.Util.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Product update | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<% AdminBean admin = (AdminBean) session.getAttribute("abean"); if (admin == null) { response.sendRedirect(request.getContextPath() + "/AdminLogin.html"); return; } String message = (String) request.getAttribute("msg"); %>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-16"><section class="mx-auto max-w-xl rounded-xl border border-line bg-white p-7 shadow-sm sm:p-9"><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Catalog management</p><h1 class="font-display text-3xl font-normal"><i class="bi bi-pencil-square mr-2" aria-hidden="true"></i>Update result</h1><p class="notice <%= "Product updated.".equals(message) ? "notice-success" : "notice-error" %> mt-5" role="<%= "Product updated.".equals(message) ? "status" : "alert" %>"><i class="bi <%= "Product updated.".equals(message) ? "bi-check-circle" : "bi-exclamation-circle" %> mr-2" aria-hidden="true"></i><%=Html.escape(message == null ? "No update result was provided." : message)%></p><div class="mt-7 flex flex-wrap gap-3"><a class="button-primary" href="<%=request.getContextPath()%>/view1"><i class="bi bi-box-seam mr-2" aria-hidden="true"></i>Back to products</a><a class="button-secondary" href="<%=request.getContextPath()%>/AddProduct.html"><i class="bi bi-plus-circle mr-2" aria-hidden="true"></i>Add product</a></div></section></main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>