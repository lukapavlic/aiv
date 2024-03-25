package si.um.feri.aiv.primer6;

import java.io.Serializable;

public class OcenaKnjige implements Serializable {

	private static final long serialVersionUID = 3000031329572803680L;

	private int id;

	private int ocena;

	private String knjiga;

	public OcenaKnjige() {
		this(0,"");
	}
	
	public OcenaKnjige(int ocena, String knjiga) {
		this.ocena = ocena;
		this.knjiga = knjiga;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public String getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(String knjiga) {
		this.knjiga = knjiga;
	}

	@Override
	public String toString() {
		return "Ocena id: " + getId() + ", ocena: " + getOcena();
	}

}
