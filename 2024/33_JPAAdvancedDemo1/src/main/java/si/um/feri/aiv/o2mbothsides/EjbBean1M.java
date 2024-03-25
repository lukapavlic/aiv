package si.um.feri.aiv.o2mbothsides;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.logging.Logger;

@Stateless
public class EjbBean1M implements Ejb1M {

	Logger log=Logger.getLogger(EjbBean1M.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Person1M find(int id) {
		log.info("EjbBean: find(id)");
		return em.find(Person1M.class, id);
	}

	@Override
	public Person1M save(Person1M o) {
		log.info("EjbBean: save");
		o.getContacts().forEach(c -> em.persist(c));
		em.persist(o);
		return o;
	}
	
	@Override
	public void doIt() {
		log.info("EjbBean: doIt");

		Person1M p=new Person1M("my@email.com","One","Person");
		p.getContacts().add(new Contact1M("phone","12312323",null));
		p.getContacts().add(new Contact1M("address","Some Address",null));

		em.persist(p);

		em.createQuery("select c from Contact1M c",Contact1M.class).getResultList().forEach(
				c-> log.info("Owner:"+c.getOwner())
		);
	}

}
