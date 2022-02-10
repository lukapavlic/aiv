package si.um.feri.aiv.ejb;

import java.util.List;
import java.util.logging.Logger;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

@Stateless
@Local(OsebaDao.class)
public class OsebaDaoBean implements OsebaDao {

	Logger log=Logger.getLogger(OsebaDaoBean.class.toString());
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<Oseba> vrniVse() {
		log.info("DAO: vračam vse");
		return em.createQuery("select o from Oseba o").getResultList();
	}
	
	@Override
	public Oseba najdi(String email) {
		log.info("DAO: iščem "+email);
		return em.find(Oseba.class, email);
	}
	
	@Override
	public void shrani(Oseba o) {
		log.info("DAO: shranjujem "+o);
		Oseba najdena=najdi(o.getEmail());
		if (najdena==null) em.persist(o);
		else em.merge(o);
	}
	
	@Override
	public void izbrisi(String email) {
		log.info("DAO: brišem "+email);
		Oseba najdena=najdi(email);
		if (najdena!=null) em.remove(najdena);
	}
	
	public void izbrisiKontakt(int idKontakta, String emailOsebe) {
		log.info("DAO: brišem kontakt "+idKontakta+" osebe "+emailOsebe);
		Oseba najdena=najdi(emailOsebe);
		if (najdena==null) return;
		Kontakt najden=null;
		for (Kontakt k:najdena.getKontakti())
			if (k.getId()==idKontakta)
				najden=k;
		if (najden!=null) {
			najdena.getKontakti().remove(najden);
			em.persist(najdena);
			em.remove(najden);
		}
	}
	
	@Override
	public void shraniKontakt(Kontakt k, String emailOsebe) {
		log.info("DAO: shranjujem kontakt "+k+" osebi "+emailOsebe);
		Oseba najdena=najdi(emailOsebe);
		if (najdena==null) return;
		
		najdena.getKontakti().add(k);
		em.persist(najdena);
	}
	
	@Override
	public void spremeniKontakt(Kontakt k) {
		log.info("DAO: spreminjam kontakt");
		em.merge(k);
	}

}