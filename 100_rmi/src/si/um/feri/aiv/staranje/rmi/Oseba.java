package si.um.feri.aiv.staranje.rmi;

import java.io.Serializable;

public class Oseba implements Serializable {
	
	public Oseba() {
	}
	
	public Oseba(String ime, int starost) {
		this.ime = ime;
		this.starost = starost;
	}

	private String ime;
	
	private int starost;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getStarost() {
		return starost;
	}

	public void setStarost(int starost) {
		this.starost = starost;
	}

	@Override
	public String toString() {
		return "Oseba [ime=" + ime + ", starost=" + starost + "]";
	}
	
}
