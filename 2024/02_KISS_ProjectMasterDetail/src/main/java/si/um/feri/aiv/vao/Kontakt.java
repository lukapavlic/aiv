package si.um.feri.aiv.vao;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Kontakt {
	
	public Kontakt(String tip, String naziv) {
		this.tip = tip;
		this.naziv = naziv;
		this.urejanje=true;
	}

	private int id;
	private String tip="Neznan";
	private String naziv;
	private boolean urejanje=true;
	
}
