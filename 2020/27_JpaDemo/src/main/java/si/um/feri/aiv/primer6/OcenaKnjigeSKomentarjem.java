package si.um.feri.aiv.primer6;

import javax.persistence.Entity;

@Entity
public class OcenaKnjigeSKomentarjem extends OcenaKnjige {

	private static final long serialVersionUID = 3000031329570803680L;

	public OcenaKnjigeSKomentarjem() {
		this(0,"","");
	}
	
	public OcenaKnjigeSKomentarjem(int ocena, String knjiga, String komenatar) {
		super(ocena,knjiga);
		this.komentar=komenatar;
	}
	
	private String komentar;

	public String getKomentar() {
		return komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	@Override
	public String toString() {
		return "Ocena id: " + getId() +  ", ocena: " + getOcena() +  ", komentar: " + getKomentar();
	}

}