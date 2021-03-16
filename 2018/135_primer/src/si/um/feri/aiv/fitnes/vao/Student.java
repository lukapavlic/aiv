package si.um.feri.aiv.fitnes.vao;

import javax.persistence.Entity;

@Entity
public class Student extends Oseba {

	private String vpisnaStevilka;

	public String getVpisnaStevilka() {
		return vpisnaStevilka;
	}

	public void setVpisnaStevilka(String vpisnaStevilka) {
		this.vpisnaStevilka = vpisnaStevilka;
	}
	
}
