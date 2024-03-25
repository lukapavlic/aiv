package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Oseba {

	public Oseba(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}
	
	@NotBlank
	private String email;
	private String ime;
	private String priimek;
	private Calendar datumVpisa=new GregorianCalendar();
	private List<Kontakt> kontakti=new ArrayList<Kontakt>();
	
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