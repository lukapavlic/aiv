package si.um.feri.aiv.example1;

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
	public Person find(String email) {
		log.info("EjbBean: find(email)");
		return em.find(Person.class, email);
	}

	@Override
	public Person save(Person o) {
		log.info("EjbBean: save");
		em.persist(o);
		return o;
	}
	
	@Override
	public Person merge(Person o) {
		log.info("EjbBean: merge");
		em.merge(o);
		return o;
	}

	@Override
	public void action() {
		log.info("EjbBean: action");
		
		Person mojca= find("mojca@pokrajculja.si");
		if (mojca!=null) em.remove(mojca);
		
		Person o=new Person("Mojca","Pokrajculja","mojca@pokrajculja.si");
		em.persist(o);
		o.setIme("Mojcika");
	}

}
