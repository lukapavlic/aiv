package si.um.feri.aiv;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/demo")
public class Demo extends HttpServlet {

	private static final long serialVersionUID = 5522000541678491661L;
	
	@Resource(lookup="java:jboss/datasources/ExampleDS")
	DataSource baza;
	
	private void bazaDemo(PrintWriter pw) throws Exception {
		OsebaDao od=new OsebaDao(baza);
		
		Oseba o=new Oseba("Peter", "Klepec", 0);
		od.shrani(o);
		
		pw.println("Dodana je nova oseba.<hr/>Vse osebe:");
		
		pw.println("<ul>");
		for (Oseba oo:od.vrniVse()) {
			pw.println("<li>"+oo+"</li>");
		}
		pw.println("</ul>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();

		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset='UTF-8' />");
		pw.println("		<title>Demo</title>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<h1>Demo</h1>");

		try {
			bazaDemo(pw);
		} catch (Exception e) {
			e.printStackTrace(pw);
		}
		
		pw.println("	</body>");
		pw.println("</html>");

		pw.close();
	}

}
