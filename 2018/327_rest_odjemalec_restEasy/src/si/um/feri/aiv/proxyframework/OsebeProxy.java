package si.um.feri.aiv.proxyframework;

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
import si.um.feri.aiv.vao.Oseba;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OsebeProxy {

	@GET
	Response vrniVseOsebe();
	
	@GET
	@Path("/oseba/{email}")
	public Oseba vrniOsebo(@PathParam("email") String email);

	@GET
	@Path("/oseba/{email}")
	public Response vrniOseboResponse(@PathParam("email") String email);

	@POST
	@Path("/oseba")
	public Response dodajOseboString(String o);

	@POST
	@Path("/oseba")
	public Response dodajOsebo(Oseba o);

	@PUT
	@Path("/oseba/{email}")
	public Response spremeniOsebo(@PathParam("email") String email, Oseba os);

	@DELETE
	@Path("/oseba/{email}")
	public Response izbrisiOsebo(@PathParam("email") String email);
	
}
