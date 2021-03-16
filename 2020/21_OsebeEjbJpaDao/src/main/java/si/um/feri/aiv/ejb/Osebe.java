package si.um.feri.aiv.ejb;

import java.util.List;
import si.um.feri.aiv.vao.Oseba;

public interface Osebe {

	Oseba najdi(String email);
	
	Oseba najdi(int id);

	void shrani(Oseba o);

	List<Oseba> vrniVse();

}