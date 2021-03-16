package si.um.feri.aiv.vao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Oseba implements Serializable {

	public Oseba() {
		this("","");
	}

	public Oseba(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = "";
		datumRojstva=new GregorianCalendar();
		datumVpisa=new GregorianCalendar();
	}
	
	public Oseba(String ime, String priimek, int id) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = "";
		datumRojstva=new GregorianCalendar();
		datumVpisa=new GregorianCalendar();
	}

	public static final String MOSKI="M";
	public static final String ZENSKA="Z";
	
	private List<Kontakt> kontakti=new ArrayList<>();
	
	private int id=-100;
	
	private String ime;

	private String priimek;
	
	private String spol;
	
	private Calendar datumRojstva;

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

	public Calendar getDatumVpisa() {
		return datumVpisa;
	}

	public void setDatumVpisa(Calendar datumVpisa) {
		this.datumVpisa = datumVpisa;
	}
	
	public String getSpol() {
		return spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public Calendar getDatumRojstva() {
		return datumRojstva;
	}

	public void setDatumRojstva(Calendar datumRojstva) {
		this.datumRojstva = datumRojstva;
	}

	public List<Kontakt> getKontakti() {
		return kontakti;
	}

	public void setKontakti(List<Kontakt> kontakti) {
		this.kontakti = kontakti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");
	@Override
	public String toString() {
		return ime + " " + priimek + ", "+spol+"; datum rojstva: "+sdf.format(datumRojstva.getTime())+"; vpis: "+sdf.format(datumVpisa.getTime());
	}
	
}