package si.um.feri.aiv.primer5;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kontakt5")
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
	private Oseba oseba;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "oseba_id")
	public Oseba getOseba() {
		return oseba;
	}

	public void setOseba(Oseba oseba) {
		this.oseba = oseba;
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
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) return false;
		if (obj instanceof Kontakt) {
			Kontakt o = (Kontakt) obj;
			return o.getId()==id;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}

}
