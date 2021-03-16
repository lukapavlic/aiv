package si.um.feri.aiv.fitnes.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.fitnes.vao.Trening;

@LocalBean
@Stateless
public class TreningiBean {

	Logger log=LoggerFactory.getLogger(TreningiBean.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Trening> vsiTreningi(){
		return em.createQuery("select t from Trening t").getResultList();
	}
	
	public Trening najdi(long id) {
		log.info("Išèem "+id);
		Trening ret=em.find(Trening.class, id);
		log.info("Najdem "+ret);
		return ret;
	}
	
	public void shrani(Trening t) {
		log.info("Shranjujem "+t);
		em.persist(t);
	}
	
	public void merge(Trening t) {
		log.info("Shranjujem (merge)"+t);
		em.merge(t);
	}
	
}
