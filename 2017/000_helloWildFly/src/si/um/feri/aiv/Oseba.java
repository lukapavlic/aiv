package si.um.feri.aiv;

public class Oseba {

	public Oseba() {
		this("", "");
	}

	public Oseba(String ime, String priimek) {
		this.id = -1;
		this.ime = ime;
		this.priimek = priimek;
	}
	
	public Oseba(String ime, String priimek, int id) {
		this.id = id;
		this.ime = ime;
		this.priimek = priimek;
	}

	private int id;

	private String ime;

	private String priimek;

	public String getIme() {
		return ime;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return ime + " " + priimek + " (" + id + ")";
	}
	
}