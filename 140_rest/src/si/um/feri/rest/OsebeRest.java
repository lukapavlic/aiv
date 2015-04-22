package si.um.feri.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/osebe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OsebeRest {

	//demo...
	private static List<Oseba> bazaOseb=null;
	
	static {
		bazaOseb=new ArrayList<Oseba>();
		bazaOseb.add(new Oseba("mojca@pravljice.si","Mojca","Pokrajculja"));
		bazaOseb.add(new Oseba("peter@pravljice.si","Peter","Klepec"));
		bazaOseb.add(new Oseba("martin@pravljice.si","Martin","Krpan"));
	}

	//demo!!! - v realnosti takih metod NI
	@GET
	@Path("/")
	public Response vrniVseOsebe() {
		return Response.ok(bazaOseb).build();
	}
	
	@GET
	@Path("/oseba/{email}")
	public Response vrniOsebo(@PathParam("email") String email) {
		Oseba ret=null;
		for (Oseba o: bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				ret=o;
				break;
			}
		if (ret!=null) {
			return Response.ok(ret).build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

	@POST
	@Path("/dodajOsebo")
	public Response dodajOsebo(Oseba o) {
		bazaOseb.add(o);
		return Response.ok(o).build();
	}

	@PUT
	@Path("/spremeniOsebo/{email}")
	public Response spremeniOsebo(@PathParam("email") String email,Oseba os) {
		Oseba trenutna=null;
		for (Oseba o: bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				trenutna=o;
				break;
			}
		if (trenutna!=null) {
			bazaOseb.remove(trenutna);
			bazaOseb.add(os);
			return Response.ok().build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

	@DELETE
	@Path("/izbrisiOsebo/{email}")
	public Response izbrisiOsebo(@PathParam("email") String email) {
		Oseba trenutna=null;
		for (Oseba o: bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				trenutna=o;
				break;
			}
		if (trenutna!=null) {
			bazaOseb.remove(trenutna);
			return Response.ok().build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}
	
}