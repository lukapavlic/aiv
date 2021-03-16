package si.um.feri.aiv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		req.setAttribute("a", a);
		req.setAttribute("b", b);
		req.setAttribute("sum", a+b);
		req.setAttribute("dif", a-b);
		req.setAttribute("mul", a*b);
		
		req.getRequestDispatcher("result.jsp").include(req,res);
	}
}
