package si.um.feri.aiv.web.akcije;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import si.um.feri.aiv.dao.OsebaDao;
import si.um.feri.aiv.dao.OsebaDaoH2;
import si.um.feri.aiv.web.IAkcija;

/**
 * akcija vse
 * v odziv vstavi objekt "List<Oseba>" pod imenom osebe
 */
public class PregledVseh implements IAkcija {
	
	/**
	 * @see si.um.feri.aiv.web.IAkcija#dobiIme()
	 */
	public String dobiIme() {
		return "vse";
	}
	
	/**
	 * @see si.um.feri.aiv.web.IAkcija#odzivJSP()
	 */
	public String odzivJSP() {
		return "vse.jsp";
	}
	
	/**
	 * @see si.um.feri.aiv.web.IAkcija#izvediAkcijo(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			OsebaDao od=new OsebaDaoH2();
			req.setAttribute("osebe",od.vrniVse());
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
	
}
