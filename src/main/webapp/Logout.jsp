<%@ page import="com.NCart.Util.Html" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%
String logoutRole = (String) request.getAttribute("logoutRole");
String logoutName = Html.escape((String) request.getAttribute("logoutName"));
boolean personalized = ("Admin".equals(logoutRole) || "Customer".equals(logoutRole)) && !logoutName.isEmpty();
String logoutSubject = personalized ? logoutRole + " " + logoutName : null;
%>
<!DOCTYPE html>
<html lang="en">
<head><meta charset="UTF-8"><meta name="viewport" content="width=device-width, initial-scale=1"><title>Signed out | ECART</title><link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/ecart.css"></head>
<body>
<main class="page-shell grid min-h-screen place-items-center py-12"><section class="w-full max-w-lg rounded-xl border border-line bg-white p-7 text-center shadow-sm sm:p-10"><a class="brand-mark mx-auto justify-center" href="<%=request.getContextPath()%>/index.html"><span class="brand-symbol" aria-hidden="true">E</span><span class="text-xl">ECART</span></a><p class="mb-2 mt-8 text-xs font-bold uppercase tracking-[0.16em] text-teal"><i class="bi bi-box-arrow-right mr-1" aria-hidden="true"></i>Account security</p><h1 class="font-display text-3xl font-normal"><%=personalized ? logoutSubject + ", you are signed out." : "You are signed out."%></h1><p class="mt-3 leading-7 text-muted"><%=personalized ? logoutSubject + " has logged out successfully. Your session has ended securely." : "Your ECART session has ended."%></p><a class="button-primary mt-7" href="<%=request.getContextPath()%>/index.html"><i class="bi bi-house-door mr-2" aria-hidden="true"></i>Return home</a></section></main>
</body>
</html>