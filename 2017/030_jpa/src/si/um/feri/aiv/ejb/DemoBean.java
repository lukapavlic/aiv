package si.um.feri.aiv.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import si.um.feri.aiv.vao.Oseba;

@Stateless
public class DemoBean implements Demo {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void narediNekaj() {
		
		Oseba o=new Oseba("Martin", "Krpan","email@nekaj");
		em.persist(o);
		
		o.setIme("NOVO IME");
		
		System.out.println(em.find(Oseba.class, 1));
		
		Query q=em.createQuery("select o.ime from Oseba o");
		
		List<Oseba> ret=q.getResultList();
		
		for(Oseba os:ret)
			System.out.println(os);
		
	}
}
