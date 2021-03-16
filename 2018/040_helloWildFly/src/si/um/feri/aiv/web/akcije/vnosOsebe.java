package si.um.feri.aiv.web.akcije;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import si.um.feri.aiv.Oseba;
import si.um.feri.aiv.dao.OsebaDao;
import si.um.feri.aiv.dao.OsebaDaoH2;
import si.um.feri.aiv.web.IAkcija;

/**
 * akcija vnos
 * parametra ime, priimek
 * v odziv vstavi shranjen objekt "Oseba" pod imenom oseba
 * ter sporocilo (niz)
 */
public class vnosOsebe implements IAkcija {
	
	/**
	 * @see si.um.feri.aiv.web.IAkcija#dobiIme()
	 */
	public String dobiIme() {
		return "vnos";
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
			OsebaDao od=new OsebaDaoH2();
			Oseba vstavljena=new Oseba(0,req.getParameter("ime"),req.getParameter("priimek"));
			od.shrani(vstavljena);
			req.setAttribute("oseba",vstavljena);
			req.setAttribute("sporocilo","Oseba je bila uspesno dodana.");
		} catch (Exception e) {
			throw new ServletException(e.getMessage());
		}
	}
	
}
