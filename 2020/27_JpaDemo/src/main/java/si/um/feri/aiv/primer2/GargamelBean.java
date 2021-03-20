package si.um.feri.aiv.primer2;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@LocalBean
@Stateless
public class GargamelBean {

	Logger log=LoggerFactory.getLogger(GargamelBean.class);
	
	@PersistenceContext
	EntityManager em;
	
	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void ustvariGargamela() {
		log.info("ustvariGargamela()");
		Oseba o=new Oseba("Gargamel","OdAzraela","gargamel@smrkci.si");
		em.persist(o);
	}
	
}
