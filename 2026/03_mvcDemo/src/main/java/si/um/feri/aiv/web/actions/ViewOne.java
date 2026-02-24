package si.um.feri.aiv.web.actions;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import si.um.feri.aiv.Person;
import si.um.feri.aiv.dao.PersonDao;
import si.um.feri.aiv.web.IAction;

/**
 * parameter: id
 * response: person (Person), message (String)
 */
public class ViewOne implements IAction {
	
	public String getActionName() {
		return "view";
	}
	
	public String getActionView() {
		return "person.jsp";
	}

	public void executeAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PersonDao od=new PersonDao();
			Person person=od.findPerson(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("person",person);
			req.setAttribute("message","");
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
	
}
