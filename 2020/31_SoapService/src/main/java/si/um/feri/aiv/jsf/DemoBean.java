package si.um.feri.aiv.jsf;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.ejb.OsebeBean;
import si.um.feri.aiv.vao.Oseba;

@Named("demo")
@SessionScoped
public class DemoBean implements Serializable {

	Logger log=LoggerFactory.getLogger(DemoBean.class);

	@EJB
	private OsebeBean ejb;
	
	private Oseba novaOseba=new Oseba();

	private Oseba izbranaOseba=new Oseba();
	
	private String izbranEmail;
	
	public void setIzbranEmail(String email) {
		log.info("JSF BEAN: setIzbranEmail");
		izbranEmail=email;
		try {
			izbranaOseba=ejb.najdi(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getIzbranEmail() {
		return izbranEmail;
	}

	public void dodajOsebo() {
		log.info("JSF BEAN: dodajOsebo");
		try {
			ejb.shrani(novaOseba);
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
