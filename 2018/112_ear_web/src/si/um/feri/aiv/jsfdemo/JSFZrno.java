package si.um.feri.aiv.jsfdemo;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.ejb.Osebe;

@ManagedBean(name="zrno")
@SessionScoped
public class JSFZrno {
	
	Logger log=LoggerFactory.getLogger(JSFZrno.class);
	
	private String novoIme;

	@EJB
	Osebe ejb;
	
	public void dodajIme() {
		log.info("Dodajam "+novoIme);
		ejb.dodajIme(novoIme);
		novoIme="";
	}
	
	public List<String> getImena() {
		return ejb.vrniVsaImena();
	}
	
	public String getNovoIme() {
		return novoIme;
	}

	public void setNovoIme(String novoIme) {
		this.novoIme = novoIme;
	}

}