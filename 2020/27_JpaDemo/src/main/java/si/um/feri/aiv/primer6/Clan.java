package si.um.feri.aiv.primer6;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Clan {

	public Clan() {
		this("", "");
	}
	
	public Clan(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
		datumVpisa=new GregorianCalendar();
	}
	
	private String ime;
	private String priimek;
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
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");

	@Override
	public String toString() {
		return ime + " " + priimek + "; vpis: "+sdf.format(datumVpisa.getTime());
	}
	
}