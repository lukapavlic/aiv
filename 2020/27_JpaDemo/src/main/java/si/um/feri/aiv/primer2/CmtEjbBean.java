package si.um.feri.aiv.primer2;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class CmtEjbBean implements CmtEjb {

	Logger log=LoggerFactory.getLogger(CmtEjbBean.class);
	
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
