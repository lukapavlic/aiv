package si.um.feri.aiv.o2mbothsides;

import lombok.*;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class Contact1M implements Serializable {
	
	private static final long serialVersionUID = 7734285490979348226L;

	public Contact1M(String type, String title, Person1M owner) {
		this.type = type;
		this.title = title;
		this.owner = owner;
	}

	private int id;
	private String type;
	private String title;
	private Person1M owner;

}
