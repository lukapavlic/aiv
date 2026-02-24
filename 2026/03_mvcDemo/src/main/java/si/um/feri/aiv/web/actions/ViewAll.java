package si.um.feri.aiv.web.actions;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import si.um.feri.aiv.dao.PersonDao;
import si.um.feri.aiv.web.IAction;

/**
 * response: people (List<Person>)
 */
public class ViewAll implements IAction {
	
	public String getActionName() {
		return "all";
	}
	
	/**
	 * @see IAction#getActionView()
	 */
	public String getActionView() {
		return "all.jsp";
	}
	
	public void executeAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PersonDao od=new PersonDao();
			req.setAttribute("people",od.getAll());
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
	
}
