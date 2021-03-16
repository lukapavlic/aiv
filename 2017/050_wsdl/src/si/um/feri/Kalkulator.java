package si.um.feri;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebService
public class Kalkulator {
	
	Logger log=LoggerFactory.getLogger(Kalkulator.class);

	public int sestej(int a, int b) {
		log.info("Sestevam "+a+" in "+b);
		return a+b;
	}

	public int odstej(int a, int b) {
		log.info("Odštevam "+a+" in "+b);
		return a-b;
	}
	
	public int mnozi(int a, int b) {
		log.info("Množim "+a+" in "+b);
		return a*b;
	}
	
	public int deli(int a, int b) {
		log.info("Delim "+a+" in "+b);
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