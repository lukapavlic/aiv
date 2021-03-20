package si.um.feri.aiv.primer5;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless(name = "ejbPet")
public class EjbBean implements Ejb {

	Logger log=LoggerFactory.getLogger(EjbBean.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Oseba najdi(int id) {
		log.info("EjbBean: najdi(id)");
		return em.find(Oseba.class, id);
	}
	
	@Override
	public Kontakt najdiKontakt(int id) {
		log.info("EjbBean: najdiKontakt(id)");
		return em.find(Kontakt.class, id);
	}

	@Override
	public Oseba shrani(Oseba o) {
		log.info("EjbBean: shrani");
		em.persist(o);
		return o;
	}
	
}
