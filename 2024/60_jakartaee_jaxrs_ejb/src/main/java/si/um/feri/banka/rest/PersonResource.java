package si.um.feri.banka.rest;

import jakarta.ejb.EJB;
import si.um.feri.banka.dao.Dao;
import si.um.feri.banka.dto.PersonExtended;
import si.um.feri.banka.vao.Person;
import java.util.Collection;
import java.util.logging.Logger;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/people")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

	private static final Logger log=Logger.getLogger("PersonResource");

	//Dao dao= InMemoryDao.getInstance();

	@EJB
	Dao dao;

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/info")
	public String info() {
		return "PersonResource";
	}

	@GET
	public Collection<Person> getAll() {
		return dao.getAllPeople();
	}

	@GET
	@Path("/{email}")
	public Person getPerson(@PathParam("email") String email) {
		return dao.findPerson(email);
	}

	@GET
	@Path("/ext/{email}")
	public PersonExtended getPersonExtended(@PathParam("email") String email) {
		return new PersonExtended(dao.findPerson(email),dao.findBankAccountOwner(email));
	}

	@POST
	public Person addPerson(Person o) throws Exception {
		log.info("addPerson:"+o);
		return dao.save(o);
	}

	@PUT
	@Path("/{email}")
	public Person changePerson(Person o, @PathParam("email") String email) throws Exception {
		if (dao.findPerson(email)==null)
			throw new Exception("Person not found.");
		return dao.save(o);
	}

}
