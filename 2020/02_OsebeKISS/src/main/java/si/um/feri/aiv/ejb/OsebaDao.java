package si.um.feri.aiv.ejb;

import java.util.List;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

public interface OsebaDao {

	List<Oseba> vrniVse() throws Exception;
	Oseba najdi(String email) throws Exception;
	void shrani(Oseba o) throws Exception;
	void izbrisi(String email) throws Exception;
	
	void shraniKontakt(Kontakt k,String emailOsebe) throws Exception;
	void izbrisiKontakt(int idKontakta,String emailOsebe) throws Exception;

}