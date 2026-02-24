<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="errorPage.jsp"%>
<%@ include file="include/header.jsp" %>

	Name: <strong>${person.name}</strong><br/>
	Surname: <strong>${person.surname}</strong>
	<hr/>
	
	${message}<br/>
		
	<a href="Controller?action=all">Back</a>
	
<jsp:include page="include/footer.jsp"/>