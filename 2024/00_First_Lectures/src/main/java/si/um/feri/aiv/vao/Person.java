package si.um.feri.aiv.vao;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {

	public Person() {
		this("", "","");
	}
	
	public Person(String ime, String priimek, String email) {
		this.email = email;
		this.name = ime;
		this.surname = priimek;
	}
	
	@NotBlank
	private String email;
	private String name;
	private String surname;
	private LocalDateTime timestamp=LocalDateTime.now();

}