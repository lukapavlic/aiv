package si.um.feri.aiv.rest;

import javax.ejb.EJB;
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

import si.um.feri.aiv.ejb.OsebeBean;
import si.um.feri.aiv.vao.Oseba;

@Path("/osebe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OsebeResource {

	@EJB
	private OsebeBean ejb;

	@Context
    private UriInfo context;
	
	@GET
	public Response vrniVseOsebe() {
		return Response.ok(ejb.vrniVse()).build();
	}

	@GET
	@Path("/oseba/{email}")
	public Response vrniOsebo(@PathParam("email") String email) {
		Oseba ret = ejb.najdi(email);
		if (ret != null) {
			return Response.ok(ret).build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

	@POST
	@Path("/oseba")
	public Response dodajOsebo(Oseba o) {
		o=ejb.shrani(o);
		return Response.ok(o).build();
	}

	@PUT
	@Path("/oseba/{email}")
	public Response spremeniOsebo(@PathParam("email") String email, Oseba os) {
		Oseba o=ejb.najdi(email);
		if (o != null) {
			os.setId(o.getId());
			os=ejb.merge(os);
			return Response.ok(os).build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}

	@DELETE
	@Path("/oseba/{email}")
	public Response izbrisiOsebo(@PathParam("email") String email) {
		Oseba o=ejb.najdi(email);
		if (o != null) {
			ejb.izbrisi(email);
			return Response.ok().build();
		} else {
			return Response.status(403).entity("OsebeNiMogoceNajtiException").build();
		}
	}
	
}
