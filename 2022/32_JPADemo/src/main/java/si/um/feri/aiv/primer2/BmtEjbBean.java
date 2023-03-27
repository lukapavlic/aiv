package si.um.feri.aiv.primer2;

import jakarta.annotation.Resource;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionManagementType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;
import java.util.logging.Logger;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class BmtEjbBean implements BmtEjb {

	Logger log = Logger.getLogger(BmtEjbBean.class.toString());

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
