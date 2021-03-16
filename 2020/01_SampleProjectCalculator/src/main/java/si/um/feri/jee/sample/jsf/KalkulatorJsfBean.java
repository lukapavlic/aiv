package si.um.feri.jee.sample.jsf;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("kalk")
@SessionScoped
public class KalkulatorJsfBean implements Serializable {
	
	private int a;
	
	private int b;
	
	private int zmnozek;
	
	private int sestevek;
	
	public void izracunaj() {
		System.out.println("RAČUNAM");
		zmnozek=a*b;
		sestevek=a+b;
		a=0;
		b=0;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getZmnozek() {
		return zmnozek;
	}

	public void setZmnozek(int zmnozek) {
		this.zmnozek = zmnozek;
	}

	public int getSestevek() {
		return sestevek;
	}

	public void setSestevek(int sestevek) {
		this.sestevek = sestevek;
	}
	
}
