<%@page import="java.util.Iterator"%>
<%@page import="com.NCart.Bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.NCart.Bean.CustomerBean"%>
<%@page import="com.NCart.Util.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Shop products | ECART</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css">
</head>
<body>
<%
CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
ArrayList<ProductBean> products = (ArrayList<ProductBean>) session.getAttribute("productList");
if (cbean == null) { response.sendRedirect(request.getContextPath() + "/CustomerLogin.html"); return; }
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-12 sm:py-16">
  <p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">ECART catalog</p><h1 class="page-title"><i class="bi bi-box-seam mr-2" aria-hidden="true"></i>Find something useful.</h1><p class="mt-3 leading-7 text-muted">Product details and availability reflect the current catalog.</p>
  <% if (Boolean.TRUE.equals(request.getAttribute("catalogError"))) { %><p class="notice notice-error mt-8" role="alert"><i class="bi bi-exclamation-circle mr-2" aria-hidden="true"></i>The product catalog could not be loaded. Please try again later.</p><% } else if (products == null || products.isEmpty()) { %><section class="mt-9 rounded-xl border border-dashed border-line bg-white px-6 py-14 text-center"><h2 class="font-display text-2xl font-normal">No products available right now</h2><p class="mt-2 text-muted">Please check back later.</p></section><% } else { %>
  <div class="mt-9 grid gap-5 sm:grid-cols-2 xl:grid-cols-3"><% for (ProductBean product : products) { boolean available = false; try { available = Integer.parseInt(product.getpQty()) > 0; } catch (Exception ignored) { } %>
    <article class="surface-card flex flex-col p-6"><div class="flex items-start justify-between gap-3"><span class="rounded-md bg-canvas px-3 py-1 text-xs font-bold text-muted">ECART / <%=Html.escape(product.getpCode())%></span><span class="rounded-full px-3 py-1 text-xs font-bold <%=available ? "bg-teal/10 text-teal-dark" : "bg-coral/10 text-coral"%>"><%=available ? "Available" : "Unavailable"%></span></div><h2 class="mt-6 font-display text-2xl font-normal"><%=Html.escape(product.getpName())%></h2><p class="mt-2 text-sm text-muted"><%=Html.escape(product.getpComp())%></p><div class="mt-auto flex items-end justify-between gap-4 pt-8"><div><p class="m-0 text-xs font-bold uppercase tracking-[0.12em] text-muted"><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i>Price</p><p class="m-0 mt-1 text-xl font-bold text-ink"><%=Html.escape(product.getpPrice())%></p></div><% if (available) { %><a class="button-primary min-h-10 px-4 py-2" href="<%=request.getContextPath()%>/buy?pcode=<%=java.net.URLEncoder.encode(product.getpCode(), "UTF-8")%>"><i class="bi bi-eye mr-2" aria-hidden="true"></i>View &amp; buy</a><% } else { %><button class="button-secondary min-h-10 px-4 py-2" type="button" disabled>Unavailable</button><% } %></div></article>
  <% } %></div><% } %>
</main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>