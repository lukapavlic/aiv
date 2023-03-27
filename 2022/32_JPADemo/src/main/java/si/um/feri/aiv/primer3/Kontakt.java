package si.um.feri.aiv.primer3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Kontakt implements Serializable {
	
	private static final long serialVersionUID = 7734285490979348226L;

	public Kontakt() {
		this("Neznan","");
	}
	
	public Kontakt(String tip, String naziv) {
		this.tip = tip;
		this.naziv = naziv;
	}

	private int id;
	private String tip;
	private String naziv;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Kontakt [id=" + id + ", tip=" + tip + ", naziv=" + naziv + "]";
	}

}
