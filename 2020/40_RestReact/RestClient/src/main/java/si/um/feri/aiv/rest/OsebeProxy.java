package si.um.feri.aiv.rest;

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
import si.um.feri.aiv.vao.Oseba;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface OsebeProxy {

	@GET
	List<Oseba> vrniVseOsebe();
	
	@POST
	public Response dodajOsebo(Oseba o);
	
	@GET
	@Path("/{email}")
	public Oseba vrniOsebo(@PathParam("email") String email);

	@PUT
	@Path("/{email}")
	public Oseba spremeniOsebo(@PathParam("email") String email, Oseba os);

	@DELETE
	@Path("/{email}")
	public Response izbrisiOsebo(@PathParam("email") String email);
	
}
