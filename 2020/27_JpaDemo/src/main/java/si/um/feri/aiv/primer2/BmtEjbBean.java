package si.um.feri.aiv.primer2;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BmtEjbBean implements BmtEjb {

	Logger log = LoggerFactory.getLogger(BmtEjbBean.class);

	@PersistenceContext
	EntityManager em;
	
	@Resource
	SessionContext sctx;

	@Override
	public void noPaDajmo() throws Exception {
		log.info("noPaDajmo()");
		UserTransaction ut = sctx.getUserTransaction();
		ut.begin();

		Oseba o=new Oseba("Chuck","Norris","com.norris@chuck");
		em.persist(o);
		
		ut.commit();
		log.info("ut.commit()");
//		ut.rollback();
//		log.info("ut.rollback()");
	}

}
