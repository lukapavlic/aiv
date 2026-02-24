package si.um.feri.aiv.web;

import java.io.IOException;
import java.util.Vector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import si.um.feri.aiv.web.actions.ViewOne;
import si.um.feri.aiv.web.actions.ViewAll;
import si.um.feri.aiv.web.actions.AddPerson;

/**
 * Web application controller.
 * Based on the request, it selects an action (parameter "action") and executes it;
 * then forwards control to the JSP page returned by the action.
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 149363537429656487L;
	
	private Vector<IAction> actions=null;
	
	public void init() throws ServletException {
		actions =new Vector<IAction>();
		actions.add(new ViewOne());
		actions.add(new ViewAll());
		actions.add(new AddPerson());
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IAction actionToExecute=null;
		for (IAction a : actions) {
			if (a.getActionName().equals(req.getParameter("action")))
				actionToExecute=a;
		}
		if (actionToExecute==null) throw new ServletException("Action not found");
		
		actionToExecute.executeAction(req,res);
		req.getRequestDispatcher(actionToExecute.getActionView()).include(req,res);
	}

}
