package si.um.feri.aiv.ejb;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.vao.Oseba;

@Stateless
@Local(Osebe.class)
public class OsebeBean implements Osebe {

	Logger log=LoggerFactory.getLogger(OsebeBean.class);
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Oseba najdi(int id) {
		log.info("EJB BEAN: najdi(id)");
		return em.find(Oseba.class, id);
	}
	
	@Override
	public Oseba najdi(String email) {
		log.info("EJB BEAN: najdi(email)");
		Query q=em.createQuery("select o from Oseba o where o.email = :e");
		q.setParameter("e", email);
		return (Oseba)q.getSingleResult();
	}

	@Override
	public void shrani(Oseba o) {
		log.info("EJB BEAN: shrani");
		em.persist(o);
	}

	@Override
	public List<Oseba> vrniVse() {
		log.info("EJB BEAN: vrniVse)");
		return em.createQuery("select o from Oseba o").getResultList();
	}

}