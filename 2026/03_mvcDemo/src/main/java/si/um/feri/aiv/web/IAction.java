package si.um.feri.aiv.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * A single action. The action is triggered by the controller and returns the JSP page for rendering.
 */
public interface IAction {

	/**
	 * Executes the action.
	 * @param req The web request.
	 * @param res The web response. Data for rendering is added to the response.
	 * @throws ServletException
	 * @throws IOException
	 */
	void executeAction(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

	/**
	 * Returns the logical name of the action.
	 * This name is used to reference the action via the controller.
	 * @return The action name.
	 */
	String getActionName();

	/**
	 * Which JSP can render this action?
	 * @return The relative path to the JSP.
	 */
	String getActionView();
	
}
