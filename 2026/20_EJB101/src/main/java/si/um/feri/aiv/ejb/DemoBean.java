package si.um.feri.aiv.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class DemoBean implements Demo {

	@EJB
	CalculatorLocal calc;
	
	public String sayHello(String name) {
		return "Hello, "+ name;
	}
	
	public double calculate(double a, double b, double c) {
		double ret=calc.add(a, b);
		ret=calc.mul(ret, c);
		return ret;
	}

}
