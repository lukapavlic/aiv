package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import si.um.feri.aiv.vao.Oseba;

public class OsebaMemoryDao implements OsebaDao {

	Logger log=Logger.getLogger(OsebaMemoryDao.class.toString());
	
	private List<Oseba> osebe=Collections.synchronizedList(new ArrayList<Oseba>());

	@Override
	public List<Oseba> vrniVse() {
		log.info("DAO: vračam vse");
		return osebe;
	}
	
	@Override
	public Oseba najdi(String email)  {
		log.info("DAO: iščem "+email);
		for (Oseba o : osebe)
			if (o.getEmail().equals(email))
				return o;
		return null;
	}
	
	@Override
	public void shrani(Oseba o)  {
		log.info("DAO: shranjujem "+o);
		if(najdi(o.getEmail())!=null) {
			log.info("DAO: urejam "+o);
			izbrisi(o.getEmail());
		}
		osebe.add(o);	
	}
	
	@Override
	public void izbrisi(String email) {
		log.info("DAO: brišem "+email);
		for (Iterator<Oseba> i = osebe.iterator(); i.hasNext();) {
			if (i.next().getEmail().equals(email))
				i.remove();
		}
	}
	
}