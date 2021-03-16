package si.um.feri.aiv.vao;

public class Kontakt {

	public static final String DOMA="Doma";
	public static final String SLUZBA="Služba";
	public static final String DRUGO="Drugo";

	public Kontakt() {
		this(null,null,null);
	}
	
	public Kontakt(String tip, String email, String telefon) {
		this.tip = tip;
		this.email = email;
		this.telefon = telefon;
		idLastnika=-100;
	}

	private int id=-100;
	
	private String tip;
	
	private String email;
	
	private String telefon;
	
	private int idLastnika;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdLastnika() {
		return idLastnika;
	}

	public void setIdLastnika(int idLastnika) {
		this.idLastnika = idLastnika;
	}

	@Override
	public String toString() {
		return tip+": "+email+", "+telefon;
	}
	
}
