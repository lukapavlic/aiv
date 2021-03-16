package si.um.feri.aiv.fitnes.ejb;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.fitnes.vao.Oseba;
import si.um.feri.aiv.fitnes.vao.Student;
import si.um.feri.aiv.fitnes.vao.Trening;

@LocalBean
@Stateless
public class DemoBean {
	
	Logger log=LoggerFactory.getLogger(DemoBean.class);
	
	@PersistenceContext
	private EntityManager em;

	public void demo1() {
		log.info("------------ Demo 1 Start ----------------");
		
		
		Oseba o=new Oseba("Palèek","Smuk");
		Student s=new Student();
		s.setIme("Gargamel");
		
		em.persist(o);
		em.persist(s);
		
		
//		Trening t=new Trening();
//		t.setDniVCiklu(4);
//		em.persist(t);
//		
//		t.setDniVCiklu(5);
//		
		log.info("------------ Demo 1 Stop -----------------");
	}
	
	public void demo2() {
		log.info("------------ Demo 2 Start ----------------");
		
//		Trening t=em.find(Trening.class, 1L);
//		t.setDniVCiklu(16);
//		em.persist(t);
		
		for (Object o:
		em.createQuery("select o from Student o").getResultList())
			System.out.println(o);
			
		
		log.info("------------ Demo 2 Stop -----------------");
	}
	
	public Trening demo3() {
		log.info("------------ Demo 3 Start ----------------");
		
		
		log.info("------------ Demo 3 Stop -----------------");
		return em.find(Trening.class, 1l);
	}
	
	public void demo4(Trening t) {
		log.info("------------ Demo 3 Start ----------------");
		
		em.merge(t);
		log.info("------------ Demo 3 Stop -----------------");
	}
	
}
