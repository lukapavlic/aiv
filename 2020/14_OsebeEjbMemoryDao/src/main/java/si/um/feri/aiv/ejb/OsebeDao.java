package si.um.feri.aiv.ejb;

import java.util.List;
import javax.ejb.Local;
import si.um.feri.aiv.vao.Oseba;

@Local
public interface OsebeDao {

	Oseba najdi(String email);

	void shrani(Oseba o);

	List<Oseba> vrniVse();

}