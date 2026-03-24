package si.um.feri.aiv.example1;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @ToString
public class Person implements Serializable {

	private static final long serialVersionUID = 9205530829658839428L;

	public Person(String email, String name, String surname) {
		this.email = email;
		this.name = name;
		this.surname = surname;
	}

	private String email;
	private String name;
	private String surname;
	private LocalDateTime created= LocalDateTime.now();

}