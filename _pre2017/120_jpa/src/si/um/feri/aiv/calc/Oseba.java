package si.um.feri.aiv.calc;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab")
public class Oseba {

	public Oseba() {
		this("","");
	}
	
	public Oseba(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
	}

	private Pravljica p;
	
	private int id;
	
	private String ime;
	
	private String priimek;
	
	@Column(name="im")
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ime+" "+priimek+" ("+id+")";
	}

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Pravljica getP() {
		return p;
	}

	public void setP(Pravljica p) {
		this.p = p;
	}
	
}
