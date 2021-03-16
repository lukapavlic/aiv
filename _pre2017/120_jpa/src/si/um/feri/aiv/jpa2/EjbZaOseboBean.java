package si.um.feri.aiv.jpa2;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EjbZaOseboBean implements EjbZaOsebo {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void narediMiNekaj() {
		
		Oseba o=new Oseba();
		o.setIme("Martin");
		o.setPriimek("Krpan");
		
		Posta p=new Posta();
		p.setStevilka("2000");
		p.setIme("Maribor");
		
		o.setBivalisce(p);
		
		em.persist(p);
		em.persist(o);

		p.setIme("Nov Maribor");
		
		List<Oseba> rezultati=em.createQuery("select o from Oseba o").getResultList();
		
		for (Oseba os :rezultati) {
			System.out.println(os.getIme());
		}
		
	}
	
}
