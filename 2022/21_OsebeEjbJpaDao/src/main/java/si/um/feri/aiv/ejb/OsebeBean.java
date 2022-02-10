package si.um.feri.aiv.ejb;

import java.util.List;
import java.util.logging.Logger;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import si.um.feri.aiv.vao.Oseba;

@Stateless
@Local(Osebe.class)
public class OsebeBean implements Osebe {

	Logger log=Logger.getLogger(OsebeBean.class.toString());
	
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