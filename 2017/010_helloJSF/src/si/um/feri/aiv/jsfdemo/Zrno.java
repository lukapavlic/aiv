package si.um.feri.aiv.jsfdemo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="zrno")
@SessionScoped
public class Zrno {
	
	private String novoIme;

	private List<String> imena=new ArrayList<>();
	
	public void dodajIme() {
		imena.add(novoIme);
		System.out.println("Dodajam "+novoIme);
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