package si.um.feri.aiv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public class OsebaDao {

	Logger log=Logger.getLogger(OsebaDao.class.toString());
	
	private static List<Oseba> osebe=Collections.synchronizedList(new ArrayList<Oseba>());
	
	public Oseba najdi(String email)  {
		for (Oseba o : osebe)
			if (o.getEmail().equals(email))
				return o;
		return new Oseba();
	}

	public void shrani(Oseba o)  {
		log.info("DAO: shranjujem "+o);
		osebe.add(o);
	}

	public List<Oseba> vrniVse() {
		log.info("DAO: vracam vse");
		return osebe;
	}

}