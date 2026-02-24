package si.um.feri.aiv;

import lombok.Data;

@Data
public class Person {
	
	public Person() {
		this(-1,"","");
	}

	public Person(int id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	private int id;
	
	private String name;
	
	private String surname;

}
