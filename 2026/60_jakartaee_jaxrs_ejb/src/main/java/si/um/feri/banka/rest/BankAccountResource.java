package si.um.feri.banka.rest;

import jakarta.ejb.EJB;
import si.um.feri.banka.dao.Dao;
import si.um.feri.banka.dto.BankAccount;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/accounts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BankAccountResource {

	//Dao dao= InMemoryDao.getInstance();

	@EJB
	Dao dao;

	@GET
	@Produces({MediaType.TEXT_PLAIN})
	@Path("/info")
	public String info() {
		return "BankAccountResource";
	}

	@GET
	@Path("/")
	public List<BankAccount> getAll() {
		List<BankAccount> ret= new ArrayList<>();
		for (si.um.feri.banka.vao.BankAccount br : dao.getAllBankAccounts())
			ret.add(new BankAccount(br));
		return ret;
	}

	@GET
	@Path("/{iban}")
	public BankAccount getAccount(@PathParam("iban") String iban) {
		return new BankAccount(dao.findBankAccount(iban));
	}

	@POST
	@Path("/")
	public void addAccount(BankAccount br) throws Exception {
		dao.save(br.asVao());
	}

	@PUT
	@Path("/{iban}")
	public void changeAccount(BankAccount br, @PathParam("iban") String iban) throws Exception {
		if (dao.findBankAccount(iban)==null)
			throw new Exception("Bank account not found.");
		dao.save(br.asVao());
	}

}
