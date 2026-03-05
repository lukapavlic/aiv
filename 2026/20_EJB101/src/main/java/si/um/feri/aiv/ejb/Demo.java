package si.um.feri.aiv.ejb;

import jakarta.ejb.Remote;

@Remote
public interface Demo {

	String sayHello(String name);
	
	double calculate(double a, double b, double c);
	
}
