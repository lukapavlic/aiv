package si.um.feri.rest;

public class Oseba {

	public Oseba() {
		this("","","");
	}
	
	public Oseba(String email, String ime, String priimek) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}

	private String email;
	
	private String ime;
	
	private String priimek;

	public String getIme() {
		return ime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	
}
