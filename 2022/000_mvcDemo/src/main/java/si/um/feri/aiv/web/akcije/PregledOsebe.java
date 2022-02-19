package si.um.feri.aiv.web.akcije;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import si.um.feri.aiv.Oseba;
import si.um.feri.aiv.dao.OsebaDao;
import si.um.feri.aiv.web.IAkcija;

/**
 * akcija pregled
 * parameter id
 * v odziv vstavi objekt "Oseba" pod imenom oseba
 * ter sporocilo (prazen niz)
 */
public class PregledOsebe implements IAkcija {
	
	/**
	 * @see si.um.feri.aiv.web.IAkcija#dobiIme()
	 */
	public String dobiIme() {
		return "pregled";
	}
	
	/**
	 * @see si.um.feri.aiv.web.IAkcija#odzivJSP()
	 */
	public String odzivJSP() {
		return "oseba.jsp";
	}

	/**
	 * @see si.um.feri.aiv.web.IAkcija#izvediAkcijo(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			OsebaDao od=new OsebaDao();
			Oseba najdena=od.najdiOsebo(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("oseba",najdena);
			req.setAttribute("sporocilo","");
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
	
}
