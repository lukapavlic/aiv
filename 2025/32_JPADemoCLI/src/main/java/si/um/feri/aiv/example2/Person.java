package si.um.feri.aiv.example2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Data @NoArgsConstructor @ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Person(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}

	private String email;
	private String ime;
	private String priimek;
	private Calendar datumVpisa=new GregorianCalendar();

}