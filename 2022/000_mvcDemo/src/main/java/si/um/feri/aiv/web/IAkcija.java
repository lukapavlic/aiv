package si.um.feri.aiv.web;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Posamezna akcija. Akcijo zbudi krmilnik in preda upodobitev JSP strani
 */
public interface IAkcija {
	
	/**
	 * Izvedba akcije
	 * @param req Zahteva spletne strani
	 * @param res Odziv spletne strani. V odziv dajemo podatke za upodobitev
	 * @throws ServletException
	 * @throws IOException
	 */
	void izvediAkcijo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	
	/**
	 * Vračanje logičnega imena akcije
	 * S tem imenom se sklicujemo na akcijo preko krmilnika
	 * @return Ime akcije
	 */
	String dobiIme();

	/**
	 * Kateri JSP zna upodobiti to akcijo?
	 * @return Relativno podana pot do JSPja
	 */
	String odzivJSP();
	
}
