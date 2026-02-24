<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="errorPage.jsp" %>
<jsp:include page="include/header.jsp"/>

	<form name="form1" action="Controller" method="get">
		<input type="hidden" name="action" value="add" />
		<table border="1">
			<tr>
				<td>Name</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>Surname</td>
				<td><input type="text" name="surname"/></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" name="submit" value="Add person"/></td>
			</tr>
		</table>	
	</form>
	
<jsp:include page="include/footer.jsp"/>
