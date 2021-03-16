package si.um.feri.aiv.fitnes.vao;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;

@Entity
@Inheritance
public class Oseba implements Serializable {

	public Oseba() {
		this("", "");
	}

	public Oseba(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = "";
		datumRojstva = new GregorianCalendar();
		datumVpisa = new GregorianCalendar();
	}

	public Oseba(String ime, String priimek, int id) {
		this.ime = ime;
		this.priimek = priimek;
		this.spol = "";
		datumRojstva = new GregorianCalendar();
		datumVpisa = new GregorianCalendar();
	}

	public static final String MOSKI = "M";
	public static final String ZENSKA = "Z";

	private int id;

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

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");

	@Override
	public String toString() {
		return ime + " " + priimek + ", " + spol + "; datum rojstva: " + sdf.format(datumRojstva.getTime()) + "; vpis: " + sdf.format(datumVpisa.getTime());
	}
	
}
