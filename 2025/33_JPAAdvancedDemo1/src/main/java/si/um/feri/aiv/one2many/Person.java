package si.um.feri.aiv.one2many;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity(name = "Person")
@Data @NoArgsConstructor @ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Person(String ime, String priimek, String email) {
		this.email = email;
		this.name = ime;
		this.surname = priimek;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String email;
	private String name;
	private String surname;

	@OneToMany//(fetch = FetchType.EAGER)
	//@JoinColumn(name = "person_id")
	private Collection<Contact> contacts=new ArrayList<>();

}