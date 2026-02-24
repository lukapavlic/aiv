<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="errorPage.jsp"%>
<jsp:include page="include/header.jsp"/>

	<%
	response.sendRedirect("Controller?action=all");
	%>
	
<jsp:include page="include/footer.jsp"/>