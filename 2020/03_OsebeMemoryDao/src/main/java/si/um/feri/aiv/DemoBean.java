package si.um.feri.aiv;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("demo")
@SessionScoped
public class DemoBean implements Serializable {

	private static final long serialVersionUID = -4576958665520233267L;

	Logger log=LoggerFactory.getLogger(DemoBean.class);
	
	private OsebaDao dao=new OsebaDao();

	private Oseba novaOseba=new Oseba();

	private Oseba izbranaOseba=new Oseba();

	public String izberiOsebo(String email) {
		log.info("JSF BEAN: izberiOsebo");
		try {
			izbranaOseba=dao.najdi(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "podrobnosti.xhtml";
	}

	public void dodajOsebo() {
		log.info("JSF BEAN: dodajOsebo");
		try {
			dao.shrani(novaOseba);
			novaOseba=new Oseba();
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

}
