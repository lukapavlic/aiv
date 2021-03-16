package si.um.feri.aiv.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.vao.Oseba;

@Stateless
public class OsebeBean {

	Logger log=LoggerFactory.getLogger(OsebeBean.class);
	
	@PersistenceContext
	EntityManager em;
	
	public Oseba najdi(int id) {
		log.info("najdi "+id);
		return em.find(Oseba.class, id);
	}
	
	public Oseba najdi(String email) {
		log.info("najdi "+email);
		Query q=em.createQuery("select o from Oseba o where o.email = :e");
		q.setParameter("e", email);
		Oseba ret=null;
		try {
			ret=(Oseba)q.getResultList().get(0);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return ret;
	}

	public Oseba shrani(Oseba o) {
		log.info("shrani "+o);
		em.persist(o);
		return o;
	}

	public Oseba merge(Oseba o) {
		log.info("merge "+o);
		em.merge(o);
		return o;
	}
	
	public void izbrisi(String email) {
		Oseba o=najdi(email);
		if (o==null) return;
		em.remove(o);
	}
	
	public List<Oseba> vrniVse() {
		log.info("vrniVse");
		return em.createQuery("select o from Oseba o").getResultList();
	}

}