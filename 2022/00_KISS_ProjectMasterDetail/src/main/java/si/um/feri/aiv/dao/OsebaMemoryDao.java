package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

public class OsebaMemoryDao implements OsebaDao {

	Logger log=Logger.getLogger(OsebaMemoryDao.class.toString());
	
	private OsebaMemoryDao() {
		osebe=Collections.synchronizedList(new ArrayList<Oseba>());
	}

	private static OsebaMemoryDao instance=new OsebaMemoryDao();

	public static OsebaMemoryDao getInstance() {
		return instance;
	}
	
	private List<Oseba> osebe;

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
	
	@Override
	public void izbrisiKontakt(int idKontakta, String emailOsebe) {
		log.info("DAO: brišem kontakt "+idKontakta+" osebe "+emailOsebe);
		Oseba najdena=najdi(emailOsebe);
		if (najdena==null) return;
		for (Iterator<Kontakt> i = najdena.getKontakti().iterator(); i.hasNext();) {
			if (i.next().getId()==idKontakta)
				i.remove();
		}
	}
	
	@Override
	public void shraniKontakt(Kontakt k, String emailOsebe) {
		log.info("DAO: shranjujem kontakt "+k+" osebi "+emailOsebe);
		Oseba najdena=najdi(emailOsebe);
		if (najdena==null) return;
		izbrisiKontakt(k.getId(), emailOsebe);
		k.setId(najdena.getMaxKontaktId()+1);
		najdena.getKontakti().add(k);
	}

}