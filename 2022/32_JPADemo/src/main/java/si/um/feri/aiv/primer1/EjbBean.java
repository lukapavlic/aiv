package si.um.feri.aiv.primer1;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class EjbBean implements Ejb {

	Logger log=Logger.getLogger(EjbBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Oseba najdi(String email) {
		log.info("EjbBean: najdi(email)");
		return em.find(Oseba.class, email);
	}

	@Override
	public Oseba shrani(Oseba o) {
		log.info("EjbBean: shrani");
		em.persist(o);
		return o;
	}
	
	@Override
	public Oseba shraniMerge(Oseba o) {
		log.info("EjbBean: shrani");
		em.merge(o);
		return o;
	}

	@Override
	public void akcija() {
		log.info("EjbBean: akcija");
		
		Oseba mojca=najdi("mojca@pokrajculja.si");
		if (mojca!=null) em.remove(mojca);
		
		Oseba o=new Oseba("Mojca","Pokrajculja","mojca@pokrajculja.si");
		em.persist(o);
		o.setIme("Mojcika");
	}

}
