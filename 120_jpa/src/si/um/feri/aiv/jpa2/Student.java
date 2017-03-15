package si.um.feri.aiv.jpa2;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("S")
public class Student extends Oseba {

	private String vpisna;

	public String getVpisna() {
		return vpisna;
	}

	public void setVpisna(String vpisna) {
		this.vpisna = vpisna;
	}
	
}
