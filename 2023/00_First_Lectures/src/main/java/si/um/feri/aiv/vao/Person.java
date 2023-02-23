package si.um.feri.aiv.vao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import jakarta.validation.constraints.NotBlank;

public class Person {

	public Person() {
		this("", "","");
	}
	
	public Person(String ime, String priimek, String email) {
		this.email = email;
		this.name = ime;
		this.surname = priimek;
		timestamp =new GregorianCalendar();
	}
	
	@NotBlank
	private String email;
	private String name;
	private String surname;
	private Calendar timestamp;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Calendar timestamp) {
		this.timestamp = timestamp;
	}

	private static SimpleDateFormat sdf=new SimpleDateFormat("dd. MM. yyyy HH:mm:ss");

	@Override
	public String toString() {
		return name + " " + surname + " ("+email+"); vpis: "+sdf.format(timestamp.getTime());
	}
	
}