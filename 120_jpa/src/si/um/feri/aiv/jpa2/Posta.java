package si.um.feri.aiv.jpa2;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Posta {

	private int id;
	
	private String stevilka;
	
	private String ime;

	private List<Oseba> prebivalci;
	
	@OneToMany
	public List<Oseba> getPrebivalci() {
		return prebivalci;
	}

	public void setPrebivalci(List<Oseba> prebivalci) {
		this.prebivalci = prebivalci;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStevilka() {
		return stevilka;
	}

	public void setStevilka(String stevilka) {
		this.stevilka = stevilka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}
	
}
