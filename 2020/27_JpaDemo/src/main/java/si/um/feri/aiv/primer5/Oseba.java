package si.um.feri.aiv.primer5;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "oseba5")
public class Oseba implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Oseba() {
		this("", "","");
	}
	
	public Oseba(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
		kontakti=new ArrayList<Kontakt>();
	}
	
	private int id;
	private String email;
	private String ime;
	private String priimek;
	private Calendar datumVpisa;
	private Collection<Kontakt> kontakti;

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "oseba")
	public Collection<Kontakt> getKontakti() {
		return kontakti;
	}

	public void setKontakti(Collection<Kontakt> kontakti) {
		this.kontakti = kontakti;
	}

	public void dodajKontakt(Kontakt k) {
		kontakti.add(k);
		k.setOseba(this);
	}
	
	public void odstraniKontakt(Kontakt k) {
		kontakti.remove(k);
		k.setOseba(null);
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
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

	public Calendar getDatumVpisa() {
		return datumVpisa;
	}

	public void setDatumVpisa(Calendar datumVpisa) {
		this.datumVpisa = datumVpisa;
	}
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");

	@Override
	public String toString() {
		return ime + " " + priimek + " ("+email+"); vpis: "+sdf.format(datumVpisa.getTime());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj==null) return false;
		if (obj instanceof Oseba) {
			Oseba o = (Oseba) obj;
			return o.getId()==id;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id;
	}
	
}