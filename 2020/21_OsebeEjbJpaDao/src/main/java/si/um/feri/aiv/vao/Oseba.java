package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Oseba {

	public Oseba() {
		this("", "","");
	}

	public Oseba(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
	}
	
	public Oseba(String ime, String priimek, String email, int id) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
	}

	private int id;
	
	private String ime;

	private String priimek;
	
	private String email;

	private Calendar datumVpisa;
	
	private Posta bivalisce;

	@ManyToOne(fetch=FetchType.EAGER)
	public Posta getBivalisce() {
		return bivalisce;
	}

	public void setBivalisce(Posta bivalisce) {
		this.bivalisce = bivalisce;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return id+": "+ime + " " + priimek + " ("+email+"); vpis: "+sdf.format(datumVpisa.getTime());
	}
	
}