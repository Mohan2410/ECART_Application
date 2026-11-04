<%@page import="com.NCart.Bean.AdminBean,com.NCart.Util.Html"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Admin dashboard | ECART</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css">
</head>
<body>
<%
AdminBean abean = (AdminBean) session.getAttribute("abean");
if (abean == null) { response.sendRedirect(request.getContextPath() + "/AdminLogin.html"); return; }
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-12 sm:py-16">
  <p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Store management</p>
  <h1 class="page-title">Welcome, <%=Html.escape(abean.getaFNAME())%>.</h1>
  <p class="mt-3 text-lg leading-7 text-muted">Choose a catalog task to continue.</p>
  <div class="mt-9 grid gap-5 md:grid-cols-2">
    <a class="surface-card group p-7 no-underline" href="<%=request.getContextPath()%>/pls"><span class="text-xs font-bold uppercase tracking-[0.16em] text-coral">01 / Create</span><h2 class="mt-4 font-display text-2xl font-normal"><i class="bi bi-plus-circle mr-2 text-teal" aria-hidden="true"></i>Add a product <span aria-hidden="true">&#8599;</span></h2><p class="mt-2 leading-7 text-muted">Add a product to the existing catalog.</p></a>
    <a class="surface-card group p-7 no-underline" href="<%=request.getContextPath()%>/view1"><span class="text-xs font-bold uppercase tracking-[0.16em] text-coral">02 / Maintain</span><h2 class="mt-4 font-display text-2xl font-normal"><i class="bi bi-box-seam mr-2 text-teal" aria-hidden="true"></i>View products <span aria-hidden="true">&#8599;</span></h2><p class="mt-2 leading-7 text-muted">Review, edit, or remove catalog products.</p></a>
  </div>
</main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>