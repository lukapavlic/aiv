package si.um.feri.aiv.ejb;

import javax.ejb.Remote;

@Remote
public interface Demo {

	String pozdraviMe(String ime);
	
	double racunaj(double a, double b, double c);
	
}
