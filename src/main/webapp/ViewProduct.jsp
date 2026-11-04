<%@page import="java.util.Iterator"%>
<%@page import="com.NCart.Bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.NCart.Bean.AdminBean"%>
<%@page import="com.NCart.Util.Html,com.NCart.Util.WebSecurity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manage products | ECART</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css">
</head>
<body>
<%
AdminBean abean = (AdminBean) session.getAttribute("abean");
ArrayList<ProductBean> products = (ArrayList<ProductBean>) session.getAttribute("productList");
if (abean == null) { response.sendRedirect(request.getContextPath() + "/AdminLogin.html"); return; }
String actionMessage = (String) session.getAttribute("productActionMessage");
session.removeAttribute("productActionMessage");
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-12 sm:py-16">
  <div class="flex flex-col justify-between gap-5 sm:flex-row sm:items-end"><div><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Catalog management</p><h1 class="page-title"><i class="bi bi-box-seam mr-2" aria-hidden="true"></i>Products</h1><p class="mt-3 leading-7 text-muted">Review current catalog records and choose an action.</p></div><a class="button-primary" href="<%=request.getContextPath()%>/pls"><i class="bi bi-plus-circle mr-2" aria-hidden="true"></i>Add product</a></div>
  <% if (actionMessage != null) { boolean actionFailed = actionMessage.contains("not"); %><p class="notice <%=actionFailed ? "notice-error" : "notice-success"%> mt-6" role="<%=actionFailed ? "alert" : "status"%>"><i class="bi <%=actionFailed ? "bi-exclamation-circle" : "bi-check-circle"%> mr-2" aria-hidden="true"></i><%=Html.escape(actionMessage)%></p><% } %>
  <% if (Boolean.TRUE.equals(request.getAttribute("catalogError"))) { %>
    <p class="notice notice-error mt-8" role="alert">The product catalog could not be loaded. Please try again later.</p>
  <% } else if (products == null || products.isEmpty()) { %>
    <section class="mt-9 rounded-xl border border-dashed border-line bg-white px-6 py-14 text-center"><h2 class="font-display text-2xl font-normal">No products to show</h2><p class="mt-2 text-muted">Add a product to begin managing the catalog.</p></section>
  <% } else { %>
    <div class="mt-9 overflow-x-auto rounded-xl border border-line bg-white shadow-sm"><table class="data-table min-w-[720px]"><caption class="sr-only">Current ECART products and available administrator actions</caption><thead><tr><th>Code</th><th>Product</th><th>Company</th><th>Price</th><th>Quantity</th><th>Actions</th></tr></thead><tbody>
    <% for (ProductBean product : products) { %><tr><td class="font-mono text-xs"><%=Html.escape(product.getpCode())%></td><td class="font-bold text-ink"><%=Html.escape(product.getpName())%></td><td><%=Html.escape(product.getpComp())%></td><td><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i><%=Html.escape(product.getpPrice())%></td><td><i class="bi bi-boxes mr-1" aria-hidden="true"></i><%=Html.escape(product.getpQty())%></td><td><div class="flex items-center gap-3"><a class="font-bold text-teal underline underline-offset-4" href="<%=request.getContextPath()%>/edit?pcode=<%=java.net.URLEncoder.encode(product.getpCode(), "UTF-8")%>"><i class="bi bi-pencil-square mr-1" aria-hidden="true"></i>Edit</a><form action="<%=request.getContextPath()%>/delete" method="post" onsubmit="return confirm('Delete this product from the catalog?')" data-disable-on-submit><input type="hidden" name="pcode" value="<%=Html.escape(product.getpCode())%>"><input type="hidden" name="csrfToken" value="<%=WebSecurity.csrfToken(session)%>"><button class="font-bold text-coral underline underline-offset-4" type="submit"><i class="bi bi-trash mr-1" aria-hidden="true"></i>Delete</button></form></div></td></tr><% } %>
    </tbody></table></div>
  <% } %>
</main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>