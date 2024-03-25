package si.um.feri.aiv.patterns.prototip;

public class Kontakt implements Cloneable {

	public Kontakt(String podatki) {
		this.podatki=podatki;
	}
	
	private String podatki;
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	@Override
	public String toString() {
		return super.toString()+": "+podatki;
	}
	
}
