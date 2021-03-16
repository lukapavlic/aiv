package si.um.feri.aiv.soap;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.WebService;
import si.um.feri.aiv.ejb.OsebeBean;
import si.um.feri.aiv.vao.Oseba;

@WebService
public class OsebeSoap {

	@EJB
	private OsebeBean ejb;

	public List<Oseba> vrniVseOsebe() {
		return ejb.vrniVse();
	}

	public Oseba vrniOsebo(String email) {
		return ejb.najdi(email);
	}

	public Oseba dodajOsebo(Oseba o) {
		return ejb.shrani(o);
	}

	public Oseba spremeniOsebo(String email, Oseba os) throws OsebeNiMogoceNajtiException {
		Oseba o=ejb.najdi(email);
		if (o != null) {
			os.setId(o.getId());
			return ejb.merge(os);
		} else {
			throw new OsebeNiMogoceNajtiException();
		}
	}

	public void izbrisiOsebo(String email) throws OsebeNiMogoceNajtiException {
		Oseba o=ejb.najdi(email);
		if (o != null) {
			ejb.izbrisi(email);
		} else {
			throw new OsebeNiMogoceNajtiException();
		}
	}
	
}
