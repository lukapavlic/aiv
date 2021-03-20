package si.um.feri.aiv.ejb;

import java.util.List;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

public interface OsebaDao {

	List<Oseba> vrniVse();
	Oseba najdi(String email);
	void shrani(Oseba o);
	void izbrisi(String email);
	
	void shraniKontakt(Kontakt k,String emailOsebe);
	void spremeniKontakt(Kontakt k);
	void izbrisiKontakt(int idKontakta,String emailOsebe);

}