package si.um.feri.aiv.jsf;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.ejb.OsebeBean;
import si.um.feri.aiv.vao.Oseba;

@ManagedBean(name="demo")
@SessionScoped
public class DemoBean {

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
