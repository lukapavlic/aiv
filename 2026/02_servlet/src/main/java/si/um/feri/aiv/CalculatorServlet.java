package si.um.feri.aiv;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalculatorServlet extends HttpServlet {

	private static final long serialVersionUID = 6221330797997338577L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		int a=0;
		int b=0;
		try {
			a=Integer.parseInt(req.getParameter("a"));
			b=Integer.parseInt(req.getParameter("b"));
		} catch (Exception e) {
		}
		
		PrintWriter pw=res.getWriter();
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset='UTF-8' />");
		pw.println("		<title>Calculator</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<h1>Calculator</h1>");
		pw.println("		"+a+" + "+b+" = "+(a+b)+"<br/>");
		pw.println("		"+a+" - "+b+" = "+(a-b)+"<br/>");
		pw.println("		"+a+" x "+b+" = "+(a*b)+"<br/>");
		pw.println("	</body>");
		pw.println("</html>");
		
		pw.close();
	}
}
