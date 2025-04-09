package si.um.feri.aiv.example2;

import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.SessionContext;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class CmtEjbBean implements CmtEjb {

	Logger log=Logger.getLogger(CmtEjbBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@EJB
	GargamelBean gargamel;
	
	@Resource
	SessionContext sctx;
	
	@Override
	public Person newPerson() {
		log.info("newPerson()");
		Person o=new Person("Miki","Misek","miki@disney.com");
		em.persist(o);
		gargamel.createGargamel();
		return o;
	}
	
	@Override
	public void twoNewPeople() {
		log.info("twoNewPeople()");
		Person o=new Person("Racman","Jaka","racman@disney.com");
		em.persist(o);
		Person o2=new Person("Pluton","","");
		em.persist(o2);
	}
	
	@Override
	public void justKiddin() {
		log.info("justKiddin()");
		Person o=new Person("Racman","Jaka","racman@disney.com");
		em.persist(o);
		gargamel.createGargamel();
		Person o2=new Person("Pluton","","pluton@disney.com");
		em.persist(o2);
		sctx.setRollbackOnly();
	}

}
