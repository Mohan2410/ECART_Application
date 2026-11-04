<%@page import="com.NCart.Bean.AdminBean,com.NCart.Util.Html,com.NCart.Util.WebSecurity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Add product | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<% AdminBean admin = (AdminBean) session.getAttribute("abean"); if (admin == null) { response.sendRedirect(request.getContextPath() + "/AdminLogin.html"); return; } String message = (String) request.getAttribute("msg"); %>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-12 sm:py-16"><div class="mx-auto max-w-3xl"><p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Catalog management</p><h1 class="page-title"><i class="bi bi-plus-circle mr-2" aria-hidden="true"></i>Add a product.</h1><p class="mt-3 leading-7 text-muted">Add the product details used by the existing store catalog.</p>
  <% if (message != null) { %><p class="notice notice-error mt-6" role="alert"><%=Html.escape(message)%></p><% } %>
  <form class="mt-8 grid gap-5 rounded-xl border border-line bg-white p-6 shadow-sm sm:grid-cols-2 sm:p-8" action="<%=request.getContextPath()%>/pls" method="post" data-disable-on-submit>
    <div><label class="field-label" for="pCode"><i class="bi bi-upc-scan mr-1" aria-hidden="true"></i>Product code</label><input class="field-input" id="pCode" name="pCode" type="text" value="<%=Html.escape(request.getParameter("pCode"))%>" required></div>
    <div><label class="field-label" for="pName"><i class="bi bi-box-seam mr-1" aria-hidden="true"></i>Product name</label><input class="field-input" id="pName" name="pName" type="text" value="<%=Html.escape(request.getParameter("pName"))%>" required></div>
    <div><label class="field-label" for="pComp"><i class="bi bi-building mr-1" aria-hidden="true"></i>Company</label><input class="field-input" id="pComp" name="pComp" type="text" value="<%=Html.escape(request.getParameter("pComp"))%>" required></div>
    <div><label class="field-label" for="pPrice"><i class="bi bi-currency-rupee mr-1" aria-hidden="true"></i>Price</label><input class="field-input" id="pPrice" name="pPrice" type="number" min="0" step="0.01" inputmode="decimal" value="<%=Html.escape(request.getParameter("pPrice"))%>" required></div>
    <div><label class="field-label" for="pQty"><i class="bi bi-boxes mr-1" aria-hidden="true"></i>Quantity</label><input class="field-input" id="pQty" name="pQty" type="number" min="0" step="1" inputmode="numeric" value="<%=Html.escape(request.getParameter("pQty"))%>" required></div>
    <input type="hidden" name="csrfToken" value="<%=WebSecurity.csrfToken(session)%>">
    <div class="flex items-end gap-3"><button class="button-primary" type="submit"><i class="bi bi-plus-circle mr-2" aria-hidden="true"></i>Add product</button><a class="button-secondary" href="<%=request.getContextPath()%>/AdminHome.jsp">Cancel</a></div>
  </form>
</div></main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>