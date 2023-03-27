package si.um.feri.aiv.primer6;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.logging.Logger;

@Stateless(name = "ejbSest")
public class EjbBean implements Ejb {

	Logger log=Logger.getLogger(EjbBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public OcenaKnjige najdi(int id) {
		log.info("EjbBean: najdi(id)");
		return em.find(OcenaKnjige.class, id);
	}
	
	@Override
	public OcenaKnjige shrani(OcenaKnjige o) {
		log.info("EjbBean: shrani(o)");
		em.persist(o);
		return o;
	}
	
	@Override
	public List<OcenaKnjige> vrniVse() {
		log.info("EjbBean: vrniVse()");
		return em.createQuery("select o from OcenaKnjige o").getResultList();
	}
	
	@Override
	public List<OcenaKnjigeSKomentarjem> vrniVseSKomentarjem() {
		log.info("EjbBean: vrniVseSKomentarjem()");
		return em.createQuery("select o from OcenaKnjigeSKomentarjem o").getResultList();
	}
	
}
