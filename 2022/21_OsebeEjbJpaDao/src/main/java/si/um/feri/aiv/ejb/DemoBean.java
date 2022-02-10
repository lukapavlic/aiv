package si.um.feri.aiv.ejb;

import java.util.List;
import java.util.logging.Logger;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.aiv.vao.Oseba;

@Stateless
public class DemoBean implements Demo {
	
	Logger log=Logger.getLogger(DemoBean.class.toString());

	@PersistenceContext
	EntityManager em;

	@Override
	public void narediNekaj() {
		Oseba o = new Oseba("Martin", "Krpan", "email@nekaj");
		em.persist(o);

		o.setIme("NOVO IME");

		log.info(""+em.find(Oseba.class, 1));

		Query q = em.createQuery("select o from Oseba o");

		List<Oseba> ret = q.getResultList();

		for (Oseba os : ret)
			log.info(""+os);

	}
}
