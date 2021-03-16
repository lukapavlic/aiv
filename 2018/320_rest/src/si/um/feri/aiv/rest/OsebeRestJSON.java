package si.um.feri.aiv.rest;

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

@Path("osebejson")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OsebeRestJSON extends OsebeRest {

	@Context
    private UriInfo context;
	
	@GET
	public Response vrniVseOsebe() {
		System.out.println(context.getPath());
		return super.vrniVseOsebe();
	}

	@GET
	@Path("/oseba/{email}")
	public Response vrniOsebo(@PathParam("email") String email) {
		return super.vrniOsebo(email);
	}

	@POST
	@Path("/oseba")
	public Response dodajOsebo(Oseba o) {
		return super.dodajOsebo(o);
	}

	@PUT
	@Path("/oseba/{email}")
	public Response spremeniOsebo(@PathParam("email") String email, Oseba os) {
		return super.spremeniOsebo(email, os);
	}

	@DELETE
	@Path("/oseba/{email}")
	public Response izbrisiOsebo(@PathParam("email") String email) {
		return super.izbrisiOsebo(email);
	}

}