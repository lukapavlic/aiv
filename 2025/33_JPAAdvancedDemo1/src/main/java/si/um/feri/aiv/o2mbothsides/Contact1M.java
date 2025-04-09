package si.um.feri.aiv.o2mbothsides;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter @Setter @NoArgsConstructor
public class Contact1M implements Serializable {
	
	private static final long serialVersionUID = 7734285490979348226L;

	public Contact1M(String type, String title, Person1M owner) {
		this.type = type;
		this.title = title;
		this.owner = owner;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;
	private String title;

	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Person1M owner;

}
