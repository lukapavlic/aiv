package si.um.feri.aiv.vao;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Oseba {

	public Oseba() {
		this("", "","");
	}

	public Oseba(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}
	
	public Oseba(String ime, String priimek, String email, int id) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}

	private int id;
	
	private String ime;

	private String priimek;
	
	private String email;

	private Calendar datumVpisa=new GregorianCalendar();
	
	private Posta bivalisce;

	public Posta getBivalisce() {
		return bivalisce;
	}

	public void setBivalisce(Posta bivalisce) {
		this.bivalisce = bivalisce;
	}

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

	@Override
	public String toString() {
		return id+": "+ime + " " + priimek + " ("+email+"); vpis: "+datumVpisa;
	}
	
}