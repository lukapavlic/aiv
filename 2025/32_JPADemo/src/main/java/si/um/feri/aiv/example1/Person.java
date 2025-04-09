package si.um.feri.aiv.example1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
@Data @NoArgsConstructor @ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Person(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}

	@Id
	private String email;
	private String ime;
	private String priimek;
	private Calendar datumVpisa=new GregorianCalendar();

}