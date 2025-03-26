package si.um.feri.aiv.ejb;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;

@Stateless
public class DemoBean implements Demo {

	@EJB
	CalculatorLocal calc;
	
	public String pozdraviMe(String ime) {
		return "Zdravo, "+ime;
	}
	
	public double racunaj(double a, double b, double c) {
		double ret=calc.add(a, b);
		ret=calc.mul(ret, c);
		return ret;
	}

}
