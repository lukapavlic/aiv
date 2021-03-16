package si.um.feri.aiv.patterns.prototip;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class OsebaShallow implements Cloneable {

	public OsebaShallow() {
		this("", "","");
	}

	public OsebaShallow(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
	}
	
	public OsebaShallow(String ime, String priimek, String email, int id) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
	}

	private String ime;

	private String priimek;
	
	private String email;

	private Calendar datumVpisa;
	
	private List<Kontakt> kontakti=new ArrayList<Kontakt>();
	
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

	public List<Kontakt> getKontakti() {
		return kontakti;
	}

	public void setKontakti(List<Kontakt> kontakti) {
		this.kontakti = kontakti;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(super.toString()+": "+ime + " " + priimek + " ("+email+"); vpis: "+sdf.format(datumVpisa.getTime()));
		sb.append("\n");
		for (Kontakt k :kontakti) {
			sb.append(k.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
}