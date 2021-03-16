package si.um.feri.aiv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="demo")
@SessionScoped
public class DemoBean {

	private OsebaDao dao=new OsebaDao();

	private Oseba novaOseba=new Oseba();

	private Oseba izbranaOseba=new Oseba();
	
	private String izbranEmail;
	
	public void setIzbranEmail(String email) {
		System.out.println("JSF BEAN: setIzbranEmail");
		izbranEmail=email;
		try {
			izbranaOseba=dao.najdi(email);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getIzbranEmail() {
		return izbranEmail;
	}

	public void dodajOsebo() {
		System.out.println("JSF BEAN: dodajOsebo");
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
