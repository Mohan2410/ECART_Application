<%@page import="java.math.BigDecimal,com.NCart.Bean.CustomerBean,com.NCart.Bean.ProductBean,com.NCart.Util.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Purchase confirmed | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<%
CustomerBean customer = (CustomerBean) session.getAttribute("cbean");
ProductBean product = (ProductBean) request.getAttribute("productBean");
Integer quantity = (Integer) request.getAttribute("quantity");
BigDecimal total = (BigDecimal) request.getAttribute("totalAmount");
if (customer == null) { response.sendRedirect(request.getContextPath() + "/CustomerLogin.html"); return; }
if (product == null || quantity == null || total == null) { response.sendRedirect(request.getContextPath() + "/view"); return; }
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-14 sm:py-20"><section class="mx-auto max-w-2xl rounded-xl border border-line bg-white p-7 shadow-sm sm:p-10"><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal"><i class="bi bi-check-circle mr-1" aria-hidden="true"></i>Purchase complete</p><h1 class="font-display text-4xl font-normal">Thank you, <%=Html.escape(customer.getCfname())%>.</h1><p class="mt-3 leading-7 text-muted">The inventory update was confirmed by the store.</p><div class="mt-8 border-y border-line py-6"><p class="text-xs font-bold uppercase tracking-[0.14em] text-muted"><i class="bi bi-receipt mr-1" aria-hidden="true"></i>Purchase details</p><dl class="mt-4 grid grid-cols-[auto_1fr] gap-x-6 gap-y-3 text-sm"><dt class="text-muted">Product</dt><dd class="m-0 font-bold"><%=Html.escape(product.getpName())%></dd><dt class="text-muted">Code</dt><dd class="m-0 font-mono"><%=Html.escape(product.getpCode())%></dd><dt class="text-muted">Unit price</dt><dd class="m-0"><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i><%=Html.escape(product.getpPrice())%></dd><dt class="text-muted">Quantity</dt><dd class="m-0"><i class="bi bi-boxes mr-1" aria-hidden="true"></i><%=quantity%></dd><dt class="font-bold">Total</dt><dd class="m-0 font-bold"><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i><%=Html.escape(total.setScale(2, java.math.RoundingMode.HALF_UP).toPlainString())%></dd></dl></div><div class="mt-7 flex flex-wrap gap-3"><a class="button-primary" href="<%=request.getContextPath()%>/view"><i class="bi bi-cart mr-2" aria-hidden="true"></i>Continue shopping</a><a class="button-secondary" href="<%=request.getContextPath()%>/CustomerHome.jsp"><i class="bi bi-person-circle mr-2" aria-hidden="true"></i>My account</a></div></section></main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>