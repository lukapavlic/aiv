package si.um.feri.aiv.one2many;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Entity(name = "Contact")
@Data @NoArgsConstructor @ToString
public class Contact implements Serializable {
	
	private static final long serialVersionUID = 7734285490979348226L;

	public Contact(String type, String title) {
		this.type = type;
		this.title = title;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String title;

}
