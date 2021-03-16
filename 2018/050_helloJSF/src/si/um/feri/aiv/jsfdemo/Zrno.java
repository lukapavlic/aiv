package si.um.feri.aiv.jsfdemo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="zrno")
@SessionScoped
public class Zrno {
	
	Logger log=LoggerFactory.getLogger(Zrno.class);
	
	private String novoIme;

	private List<String> imena=new ArrayList<>();
	
	public void dodajIme() {
		imena.add(novoIme);
		log.info("Dodajam "+novoIme);
		novoIme="";
	}

	public String getNovoIme() {
		return novoIme;
	}

	public void setNovoIme(String novoIme) {
		this.novoIme = novoIme;
	}

	public List<String> getImena() {
		return imena;
	}

	public void setImena(List<String> imena) {
		this.imena = imena;
	}
	
}