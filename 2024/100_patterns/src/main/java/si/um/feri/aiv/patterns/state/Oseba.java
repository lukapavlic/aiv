package si.um.feri.aiv.patterns.state;

import si.um.feri.aiv.patterns.state.stanja.DobroPocutjeOsebe;
import si.um.feri.aiv.patterns.state.stanja.PocutjeOsebe;

public class Oseba {

	public Oseba() {
		this("", "");
	}

	public Oseba(String ime, String priimek) {
		this.ime = ime;
		this.priimek = priimek;
		trenutnoPocutje=new DobroPocutjeOsebe();
	}
	
	private String ime;

	private String priimek;
	
	private PocutjeOsebe trenutnoPocutje;

	public void prepevaj() {
		System.out.println(this + " -> prepevam.");
	}

	public void plesi() {
		System.out.println(this + " -> plešem.");
	}

	public void sprehajajSe() {
		System.out.println(this + " -> grem na sprehod.");
	}

	public void ravnajGledeNaPocutje() {
		if (trenutnoPocutje!=null) trenutnoPocutje.izvajajAktivnost(this);
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

	public PocutjeOsebe getTrenutnoPocutje() {
		return trenutnoPocutje;
	}

	public void setTrenutnoPocutje(PocutjeOsebe trenutnoPocutje) {
		this.trenutnoPocutje = trenutnoPocutje;
	}

	@Override
	public String toString() {
		return "Oseba{" +
				"ime='" + ime + '\'' +
				", priimek='" + priimek + '\'' +
				", trenutnoPocutje=" + trenutnoPocutje +
				'}';
	}

}