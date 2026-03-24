package si.um.feri.aiv.example2;

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
	public void letsDoIt() throws Exception {
		log.info("letsDoIt()");
		UserTransaction ut = sctx.getUserTransaction();
		ut.begin();

		Person o=new Person("Chuck","Norris","com.norris@chuck");
		em.persist(o);
		
		ut.commit();
		log.info("ut.commit()");
//		ut.rollback();
//		log.info("ut.rollback()");
	}

}
