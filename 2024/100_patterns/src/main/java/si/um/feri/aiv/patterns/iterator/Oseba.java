package si.um.feri.aiv.patterns.iterator;

import java.text.SimpleDateFormat;
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
		datumVpisa=new GregorianCalendar();
	}
	
	public Oseba(String ime, String priimek, String email, int id) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
	}

	private String ime;

	private String priimek;
	
	private String email;

	private Calendar datumVpisa;
	
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
		return ime + " " + priimek + " ("+email+"); vpis: "+sdf.format(datumVpisa.getTime());
	}
	
}