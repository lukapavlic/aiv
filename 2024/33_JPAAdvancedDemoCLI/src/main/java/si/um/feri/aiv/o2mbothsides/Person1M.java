package si.um.feri.aiv.o2mbothsides;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Getter @Setter @NoArgsConstructor
public class Person1M implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Person1M(String email, String name, String surname) {
		this.email = email;
		this.name = name;
		this.surname = surname;
	}

	private int id;
	private String email;
	private String name;
	private String surname;
	private Collection<Contact1M> contacts=new ArrayList<>();

}