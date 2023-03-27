package si.um.feri.aiv.primer4;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless(name = "ejbStiri")
public class EjbBean implements Ejb {

	Logger log=Logger.getLogger(EjbBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Oseba najdi(int id) {
		log.info("EjbBean: najdi(id)");
		return em.find(Oseba.class, id);
	}

	@Override
	public Oseba shrani(Oseba o) {
		log.info("EjbBean: shrani");
		em.persist(o);
		return o;
	}
	
}
