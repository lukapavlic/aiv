package si.um.feri.aiv;

public class Oseba {
	
	public Oseba() {
		this(-1,"","");
	}
	
	/**
	 * Konstruktor
	 * @param id zaèetni id
	 * @param ime zaèetno ime
	 * @param priimek zaèetni priimek
	 */
	public Oseba(int id, String ime, String priimek) {
		this.id = id;
		this.ime = ime;
		this.priimek = priimek;
	}

	private int id;
	
	private String ime;
	
	private String priimek;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
	
	@Override
	public String toString() {
		return ime+" "+priimek+" (id:"+id+")"; 
	}
	
}
