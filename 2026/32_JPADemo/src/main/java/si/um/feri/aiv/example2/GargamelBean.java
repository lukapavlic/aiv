package si.um.feri.aiv.example2;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Logger;

@LocalBean
@Stateless
public class GargamelBean {

	Logger log=Logger.getLogger(GargamelBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void createGargamel() {
		log.info("createGargamel()");
		Person o=new Person("Gargamel","OdAzraela","gargamel@smrkci.si");
		em.persist(o);
	}
	
}
