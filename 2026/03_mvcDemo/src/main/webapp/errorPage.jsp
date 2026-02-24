<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=utf-8" language="java" isErrorPage="true" %>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Error occured</title>
	</head>

	<body>
		<h1>Error found!</h1>
		Details:<br/>
		<small>
		<%=exception.getMessage()%>
		</small>
		<hr/>
		StackTrace:
		<small>
		<%exception.printStackTrace(new java.io.PrintWriter(out));%>
		</small>
	</body>
	
</html>