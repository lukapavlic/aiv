package si.um.feri.aiv.web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.um.feri.aiv.web.akcije.PregledOsebe;
import si.um.feri.aiv.web.akcije.PregledVseh;
import si.um.feri.aiv.web.akcije.vnosOsebe;

/**
 * Krmilnik spletne aplikacije.
 * Na osnovi zahteve izbere akcijo (parameter "akcija") in jo izvede;
 * nato preda kontrolo JSP strani, ki jo javi akcija
 */
@WebServlet("/Krmilnik")
public class Krmilnik extends HttpServlet {

	private static final long serialVersionUID = 149363537429656487L;
	
	private Vector<IAkcija> akcije=null;
	
	/**
	 * @see javax.servlet.GenericServlet#init()
	 */
	public void init() throws ServletException {
		akcije=new Vector<IAkcija>();
		akcije.add(new PregledOsebe());
		akcije.add(new PregledVseh());
		akcije.add(new vnosOsebe());
	}
	
	/**
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		IAkcija uporabi=null;
		for (IAkcija a : akcije) {
			if (a.dobiIme().equals(req.getParameter("akcija")))
				uporabi=a;
		}
		if (uporabi==null) throw new ServletException("Akcije ni bilo mogoce najti");
		
		uporabi.izvediAkcijo(req,res);
		req.getRequestDispatcher(uporabi.odzivJSP()).include(req,res);
	}

}
