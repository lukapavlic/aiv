package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import jakarta.validation.constraints.NotBlank;

public class Oseba {

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
	
	@NotBlank
	private String email;
	private String ime;
	private String priimek;
	private Calendar datumVpisa;
	private List<Kontakt> kontakti;
	
	public List<Kontakt> getKontakti() {
		return kontakti;
	}

	public void setKontakti(List<Kontakt> kontakti) {
		this.kontakti = kontakti;
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

	public int getMaxKontaktId() {
		int ret=0;
		for (Kontakt k:kontakti)
			if (k.getId()>ret) ret=k.getId();
		return ret;
	}

	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");

	@Override
	public String toString() {
		return ime + " " + priimek + " ("+email+"); vpis: "+sdf.format(datumVpisa.getTime());
	}
	
}