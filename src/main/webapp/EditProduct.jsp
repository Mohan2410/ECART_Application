<%@page import="com.NCart.Bean.AdminBean,com.NCart.Bean.ProductBean,com.NCart.Util.Html,com.NCart.Util.WebSecurity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Edit product | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<%
AdminBean admin = (AdminBean) session.getAttribute("abean");
ProductBean product = (ProductBean) request.getAttribute("productBean");
if (admin == null) { response.sendRedirect(request.getContextPath() + "/AdminLogin.html"); return; }
if (product == null) { response.sendRedirect(request.getContextPath() + "/view1"); return; }
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-12 sm:py-16"><div class="mx-auto max-w-2xl"><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Catalog management</p><h1 class="page-title"><i class="bi bi-pencil-square mr-2" aria-hidden="true"></i>Edit product</h1><p class="mt-3 text-muted"><%=Html.escape(product.getpName())%> <span class="font-mono text-xs">/ <%=Html.escape(product.getpCode())%></span></p>
  <form class="mt-8 space-y-5 rounded-xl border border-line bg-white p-6 shadow-sm sm:p-8" action="<%=request.getContextPath()%>/update" method="post" data-disable-on-submit>
    <div><label class="field-label" for="pPrice"><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i>Price</label><input class="field-input" id="pPrice" name="pPrice" type="number" min="0" step="0.01" value="<%=Html.escape(product.getpPrice())%>" required></div>
    <div><label class="field-label" for="pQty"><i class="bi bi-boxes mr-1" aria-hidden="true"></i>Quantity</label><input class="field-input" id="pQty" name="pQty" type="number" min="0" step="1" value="<%=Html.escape(product.getpQty())%>" required></div>
    <input type="hidden" name="pcode" value="<%=Html.escape(product.getpCode())%>"><input type="hidden" name="csrfToken" value="<%=WebSecurity.csrfToken(session)%>">
    <div class="flex flex-wrap gap-3"><button class="button-primary" type="submit"><i class="bi bi-check-circle mr-2" aria-hidden="true"></i>Save changes</button><a class="button-secondary" href="<%=request.getContextPath()%>/view1">Cancel</a></div>
  </form>
</div></main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>