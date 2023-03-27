package si.um.feri.aiv.primer2;

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
	public Oseba novaOseba() {
		log.info("novaOseba()");
		Oseba o=new Oseba("Miki","Misek","miki@disney.com");
		em.persist(o);
		gargamel.ustvariGargamela();
		return o;
	}
	
	@Override
	public void dveNoviOsebi() {
		log.info("dveNoviOsebi()");
		Oseba o=new Oseba("Racman","Jaka","racman@disney.com");
		em.persist(o);
		Oseba o2=new Oseba("Pluton","","");
		em.persist(o2);
	}
	
	@Override
	public void smoSeSamoHecali() {
		log.info("smoSeSamoHecali()");
		Oseba o=new Oseba("Racman","Jaka","racman@disney.com");
		em.persist(o);
		gargamel.ustvariGargamela();
		Oseba o2=new Oseba("Pluton","","pluton@disney.com");
		em.persist(o2);
		sctx.setRollbackOnly();
	}

}
