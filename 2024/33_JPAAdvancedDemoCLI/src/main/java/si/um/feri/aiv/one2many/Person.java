package si.um.feri.aiv.one2many;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data @NoArgsConstructor @ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Person(String ime, String priimek, String email) {
		this.email = email;
		this.name = ime;
		this.surname = priimek;
	}

	private int id;
	private String email;
	private String name;
	private String surname;
	private Collection<Contact> contacts=new ArrayList<>();

}