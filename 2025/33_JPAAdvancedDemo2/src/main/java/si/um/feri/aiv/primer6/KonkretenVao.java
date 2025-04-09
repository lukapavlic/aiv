package si.um.feri.aiv.primer6;

import jakarta.persistence.Entity;

@Entity
public class KonkretenVao extends SuperVao {
	
	private String atribut1;
	
	private String atribut2;

	public String getAtribut1() {
		return atribut1;
	}

	public void setAtribut1(String atribut1) {
		this.atribut1 = atribut1;
	}

	public String getAtribut2() {
		return atribut2;
	}

	public void setAtribut2(String atribut2) {
		this.atribut2 = atribut2;
	}

}
