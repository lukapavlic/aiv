package si.um.feri.aiv.jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.naming.InitialContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.dao.KontaktDao;
import si.um.feri.aiv.dao.OsebaDao;
import si.um.feri.aiv.vao.Kontakt;
import si.um.feri.aiv.vao.Oseba;

/**
 * Model aplikacije
 * Pridobivanje vseh oseb iz podatkovne baze je realizirano v zrnu, ki je vezan na zahtevo
 */
@ManagedBean(name="osebe")
@SessionScoped
public class DemoBean implements Serializable {

	private static final long serialVersionUID = 3681925386205828132L;

	Logger log=LoggerFactory.getLogger(DemoBean.class);
	
	private Oseba novaOseba=new Oseba();

	private Oseba izbranaOseba=new Oseba();
	
	private Kontakt novKontakt=new Kontakt();

	public void izberiOsebo(String id) {
		int intId=Integer.parseInt(id);
		log.info("JSF BEAN: izberiOsebo");
		try {
			izbranaOseba=OsebaDao.getInstance().najdi(intId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dodajOsebo() {
		log.info("JSF BEAN: dodajOsebo");
		try {
			OsebaDao.getInstance().shrani(novaOseba);
			novaOseba=new Oseba();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dodajKontakt() {
		log.info("JSF BEAN: dodajKontakt");
		try {
			novKontakt.setIdLastnika(izbranaOseba.getId());
			izbranaOseba.getKontakti().add(novKontakt);
			KontaktDao.getInstance().shrani(novKontakt);
			novKontakt=new Kontakt();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Oseba getNovaOseba() {
		return novaOseba;
	}
	
	public void setNovaOseba(Oseba novaOseba) {
		this.novaOseba = novaOseba;
	}

	public Oseba getIzbranaOseba() {
		return izbranaOseba;
	}

	public void setIzbranaOseba(Oseba izbranaOseba) {
		this.izbranaOseba = izbranaOseba;
	}

	public Kontakt getNovKontakt() {
		return novKontakt;
	}

	public void setNovKontakt(Kontakt novKontakt) {
		this.novKontakt = novKontakt;
	}
	
}
