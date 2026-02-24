<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Calculator</title>
	</head>
	
	<body>
		
		<%
			int a=0;
			int b=0;
			try {
				a=Integer.parseInt(request.getParameter("a"));
				b=Integer.parseInt(request.getParameter("b"));
			} catch (Exception e) {
			}
		%>
	
		<h1>The Calculator</h1>
		
		<form action="index.jsp" method="get">
			<input name="a" type="text" value="<%=a%>" /> <br/>
			<input name="b" type="text" value="<%=b%>" /> <br/>
			<input type="submit" value="Calculate"/>
		</form>
	
		<h1>The Results</h1>
		
		<%=a%> + <%=b%> = <%=a+b%> <br/>
		<%=a%> - <%=b%> = <%=a-b%> <br/>
		<%=a%> x <%=b%> = <%=a*b%> <br/>
		
	</body>
</html>