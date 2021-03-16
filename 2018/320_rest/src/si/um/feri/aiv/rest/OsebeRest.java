package si.um.feri.aiv.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Response;

public class OsebeRest {

	protected static List<Oseba> bazaOseb = null;

	static {
		bazaOseb = new ArrayList<Oseba>();
		bazaOseb.add(new Oseba("mojca@pravljice.si", "Mojca", "Pokrajculja"));
		bazaOseb.add(new Oseba("peter@pravljice.si", "Peter", "Klepec"));
		bazaOseb.add(new Oseba("martin@pravljice.si", "Martin", "Krpan"));
	}

	// demo!!! - v realnosti takih metod NI
	protected Response vrniVseOsebe() {
		return Response.ok(bazaOseb).build();
	}

	protected Response vrniOsebo(String email) {
		Oseba ret = null;
		for (Oseba o : bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				ret = o;
				break;
			}
		if (ret != null) {
			return Response.ok(ret).build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

	protected Response dodajOsebo(Oseba o) {
		bazaOseb.add(o);
		return Response.ok(o).build();
	}

	protected Response spremeniOsebo(String email, Oseba os) {
		Oseba trenutna = null;
		for (Oseba o : bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				trenutna = o;
				break;
			}
		if (trenutna != null) {
			bazaOseb.remove(trenutna);
			bazaOseb.add(os);
			return Response.ok(os).build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

	protected Response izbrisiOsebo(String email) {
		Oseba trenutna = null;
		for (Oseba o : bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				trenutna = o;
				break;
			}
		if (trenutna != null) {
			bazaOseb.remove(trenutna);
			return Response.ok().build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

}