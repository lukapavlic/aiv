package si.um.feri.aiv.vao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Posta {

	private String koda;
	
	private String naziv;

	private List<Oseba> prebivalci;
	
	@OneToMany
	public List<Oseba> getPrebivalci() {
		return prebivalci;
	}

	public void setPrebivalci(List<Oseba> prebivalci) {
		this.prebivalci = prebivalci;
	}

	@Id
	public String getKoda() {
		return koda;
	}

	public void setKoda(String koda) {
		this.koda = koda;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
}

