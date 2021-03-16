package si.um.feri;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

@WebService
public class Kalkulator {

	public int sestej(int a, int b) {
		System.out.println("Sestevam "+a+" in "+b);
		return a+b;
	}

	public int odstej(int a, int b) {
		System.out.println("Odštevam "+a+" in "+b);
		return a-b;
	}
	
	public int mnozi(int a, int b) {
		System.out.println("Mnoim "+a+" in "+b);
		return a*b;
	}
	
	public int deli(int a, int b) {
		System.out.println("Delim "+a+" in "+b);
		return a/b;
	}
	
	public List<Racun> obdelaj(int a, int b) {
		List<Racun> ret=new ArrayList<Racun>();
		ret.add(new Racun(a+"+"+b, sestej(a, b)));
		ret.add(new Racun(a+"-"+b, odstej(a, b)));
		ret.add(new Racun(a+"*"+b, mnozi(a, b)));
		ret.add(new Racun(a+"/"+b, deli(a, b)));
		return ret;
	}
	
}