package si.um.feri;

public class Racun {

	public Racun(String racun, int rezultat) {
		this.racun = racun;
		this.rezultat = rezultat;
	}

	private String racun;
	
	private int rezultat;

	public String getRacun() {
		return racun;
	}

	public void setRacun(String racun) {
		this.racun = racun;
	}

	public int getRezultat() {
		return rezultat;
	}

	public void setRezultat(int rezultat) {
		this.rezultat = rezultat;
	}
	
}
