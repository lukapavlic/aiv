<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="include/header.jsp" />

	<ul>
		<c:forEach var="os" items="${people}">
			<li><c:out value="${os.surname}" /> <c:out value="${os.name}" />
				[<a href="Controller?action=view&id=${os.id}">view</a>]
			</li>
		</c:forEach>
	</ul>

	<hr />
	<a href="person_form.jsp">Add new person</a>

<jsp:include page="include/footer.jsp" />