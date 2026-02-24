package si.um.feri.aiv.web.actions;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import si.um.feri.aiv.Person;
import si.um.feri.aiv.dao.PersonDao;
import si.um.feri.aiv.web.IAction;

/**
 * parameters: name, surname
 * response: person (Person), message (String)
 */
public class AddPerson implements IAction {
	
	public String getActionName() {
		return "add";
	}
	
	public String getActionView() {
		return "person.jsp";
	}
	
	public void executeAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			PersonDao od=new PersonDao();
			Person added=new Person(0,req.getParameter("name"),req.getParameter("surname"));
			od.save(added);
			req.setAttribute("person",added);
			req.setAttribute("message","Person added successfully.");
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
	
}
