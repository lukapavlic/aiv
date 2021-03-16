package si.um.feri.aiv.vao;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Posta {

	private String koda;
	
	private String naziv;

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

