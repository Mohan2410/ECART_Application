<%@ page import="com.NCart.Bean.CustomerBean" %>
<%@ page import="com.NCart.Util.Html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Your account | ECART</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css">
</head>
<body>
<%
CustomerBean cbean = (CustomerBean) session.getAttribute("cbean");
if (cbean == null) { response.sendRedirect(request.getContextPath() + "/CustomerLogin.html"); return; }
%>
<%@ include file="/WEB-INF/jspf/SiteHeader.jspf" %>
<main class="page-shell py-14 sm:py-20">
  <% if ("1".equals(request.getParameter("registered"))) { %><p class="notice notice-success mb-8" role="status"><i class="bi bi-check-circle mr-2" aria-hidden="true"></i>Your ECART account has been created.</p><% } %>
  <p class="mb-2 text-xs font-bold uppercase tracking-[0.16em] text-teal">Customer account</p>
  <h1 class="page-title">Welcome, <%=Html.escape(cbean.getCfname())%>.</h1>
  <p class="mt-4 max-w-2xl text-lg leading-8 text-muted">Your account is ready. Browse the current product catalog to see items and availability maintained by the store.</p>
  <div class="mt-8 flex flex-wrap gap-3"><a class="button-primary" href="<%=request.getContextPath()%>/view"><i class="bi bi-cart mr-2" aria-hidden="true"></i>Browse products <span class="ml-2" aria-hidden="true">&#8594;</span></a><a class="button-secondary" href="<%=request.getContextPath()%>/logout"><i class="bi bi-box-arrow-right mr-2" aria-hidden="true"></i>Sign out</a></div>
</main>
<%@ include file="/WEB-INF/jspf/SiteFooter.jspf" %>
</body>
</html>