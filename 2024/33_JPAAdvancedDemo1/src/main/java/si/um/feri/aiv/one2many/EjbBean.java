package si.um.feri.aiv.one2many;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class EjbBean implements Ejb {

	Logger log=Logger.getLogger(EjbBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Person find(int id) {
		log.info("EjbBean: find(id)");
		return em.find(Person.class, id);
	}

	@Override
	public Person save(Person o) {
		log.info("EjbBean: save");
		o.getContacts().forEach(c -> em.persist(c));
		em.persist(o);
		return o;
	}
	
	@Override
	public void doIt(int id) {
		log.info("EjbBean: doIt");
		Person o2=find(id);
		log.info(o2.toString());
		o2.getContacts().forEach(c->log.info(c.toString()));
	}

}
