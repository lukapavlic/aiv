<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="napaka.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

	<ul>
		<c:forEach var="os" items="${osebe}">
			<li><c:out value="${os.priimek}" /> <c:out value="${os.ime}" />
				[<a href="Krmilnik?akcija=pregled&id=${os.id}">pregled</a>]
			</li>
		</c:forEach>
	</ul>

	<hr />
	<a href="oseba_forma.jsp">Dodaj novo osebo</a>

<jsp:include page="include/footer.jsp" />