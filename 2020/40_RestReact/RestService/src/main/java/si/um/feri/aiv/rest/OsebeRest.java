package si.um.feri.aiv.rest;

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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.vao.Oseba;

@Path("/osebe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OsebeRest {

	Logger log=LoggerFactory.getLogger(OsebeRest.class);

	@Context
    private UriInfo context;
	
	protected static List<Oseba> bazaOseb = null;

	static {
		bazaOseb = new ArrayList<Oseba>();
		bazaOseb.add(new Oseba("mojca@pravljice.si", "Mojca", "Pokrajculja"));
		bazaOseb.add(new Oseba("peter@pravljice.si", "Peter", "Klepec"));
		bazaOseb.add(new Oseba("martin@pravljice.si", "Martin", "Krpan"));
	}

	@GET
	public Response vrniVseOsebe() {
		log.info("GET:"+context.getPath());
		return Response.ok(bazaOseb).build();
	}

	@GET
	@Path("/{email}")
	public Response vrniOsebo(@PathParam("email") String email) {
		log.info("GET:"+context.getPath());
		for (Oseba o : bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail()))
				return Response.ok(o).build();
		return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
	}

	@POST
	public Oseba dodajOsebo(Oseba o) {
		log.info("POST:"+context.getPath()+"-"+o);
		bazaOseb.add(o);
		return o;
	}

	@PUT
	@Path("/{email}")
	public Response spremeniOsebo(@PathParam("email") String email, Oseba os) {
		log.info("PUT:"+context.getPath()+"-"+os);
		for (Oseba o : bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				bazaOseb.remove(o);
				bazaOseb.add(os);
				return Response.ok(os).build();
			}
		return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
	}

	@DELETE
	@Path("/{email}")
	public Response izbrisiOsebo(@PathParam("email") String email) {
		log.info("DELETE:"+context.getPath());
		for (Oseba o : bazaOseb)
			if (email.equalsIgnoreCase(o.getEmail())) {
				bazaOseb.remove(o);
				return Response.ok().build();
			}
		return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
	}

}