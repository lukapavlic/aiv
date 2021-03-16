package si.um.feri.aiv.vao;

public class Oseba {

	public Oseba() {
		this("", "","");
	}

	public Oseba(String ime, String priimek, String email) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}
	
	public Oseba(String ime, String priimek, String email, int id) {
		this.email = email;
		this.ime = ime;
		this.priimek = priimek;
	}

	private int id;
	
	private String ime;

	private String priimek;
	
	private String email;

	private long datumVpisa;
	
	private Posta bivalisce;

	public Posta getBivalisce() {
		return bivalisce;
	}

	public void setBivalisce(Posta bivalisce) {
		this.bivalisce = bivalisce;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDatumVpisa() {
		return datumVpisa;
	}

	public void setDatumVpisa(long datumVpisa) {
		this.datumVpisa = datumVpisa;
	}
	
	@Override
	public String toString() {
		return id+": "+ime + " " + priimek + " ("+email+"); vpis: "+datumVpisa;
	}
	
}