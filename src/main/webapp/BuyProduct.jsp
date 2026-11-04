<%@page import="com.NCart.Bean.CustomerBean,com.NCart.Bean.ProductBean,com.NCart.Util.Html,com.NCart.Util.WebSecurity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Purchase product | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<%
CustomerBean customer = (CustomerBean) session.getAttribute("cbean");
ProductBean product = (ProductBean) request.getAttribute("productBean");
if (customer == null) { response.sendRedirect(request.getContextPath() + "/CustomerLogin.html"); return; }
if (product == null) { response.sendRedirect(request.getContextPath() + "/view"); return; }
int available = 0;
try { available = Integer.parseInt(product.getpQty()); } catch (Exception ignored) { }
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-12 sm:py-16"><div class="mx-auto max-w-2xl"><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Purchase review</p><h1 class="page-title"><i class="bi bi-cart mr-2" aria-hidden="true"></i>Confirm your selection.</h1>
  <section class="mt-8 rounded-xl border border-line bg-white p-6 shadow-sm sm:p-8"><p class="text-xs font-bold uppercase tracking-[0.12em] text-muted">Product / <%=Html.escape(product.getpCode())%></p><h2 class="mt-3 font-display text-3xl font-normal"><%=Html.escape(product.getpName())%></h2><p class="mt-2 text-muted"><%=Html.escape(product.getpComp())%></p><div class="mt-7 flex flex-wrap justify-between gap-4 border-y border-line py-5"><div><p class="m-0 text-xs font-bold uppercase tracking-[0.12em] text-muted"><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i>Price</p><p class="m-0 mt-1 text-xl font-bold"><%=Html.escape(product.getpPrice())%></p></div><div><p class="m-0 text-xs font-bold uppercase tracking-[0.12em] text-muted"><i class="bi bi-boxes mr-1" aria-hidden="true"></i>Available quantity</p><p class="m-0 mt-1 text-xl font-bold"><%=available%></p></div></div>
  <% if (available > 0) { %><form class="mt-6 flex flex-col gap-4 sm:flex-row sm:items-end" action="<%=request.getContextPath()%>/confirmPurchase" method="post" data-disable-on-submit><div class="w-full sm:max-w-xs"><label class="field-label" for="pqty"><i class="bi bi-boxes mr-1" aria-hidden="true"></i>Quantity</label><input class="field-input" id="pqty" name="pqty" type="number" min="1" max="<%=available%>" step="1" required></div><input type="hidden" name="pcode" value="<%=Html.escape(product.getpCode())%>"><input type="hidden" name="csrfToken" value="<%=WebSecurity.csrfToken(session)%>"><button class="button-primary" type="submit"><i class="bi bi-bag-check mr-2" aria-hidden="true"></i>Place purchase</button></form><% } else { %><p class="notice notice-error mt-6" role="alert"><i class="bi bi-exclamation-circle mr-2" aria-hidden="true"></i>This product is currently unavailable.</p><% } %>
  </section><a class="mt-6 inline-flex font-bold text-teal underline underline-offset-4" href="<%=request.getContextPath()%>/view">Back to products</a>
</div></main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>