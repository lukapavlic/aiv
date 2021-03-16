<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ include file="include/header.jsp" %>

	Ime: <strong>${oseba.ime}</strong><br/>
	Priimek: <strong>${oseba.priimek}</strong>
	<hr/>
	
	${sporocilo}<br/>
		
	<a href="Krmilnik?akcija=vse">Nazaj</a>
	
<jsp:include page="include/footer.jsp"/>