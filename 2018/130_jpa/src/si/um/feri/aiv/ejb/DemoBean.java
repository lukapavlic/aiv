package si.um.feri.aiv.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.vao.Oseba;

@Stateless
public class DemoBean implements Demo {
	
	Logger log=LoggerFactory.getLogger(DemoBean.class);

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
