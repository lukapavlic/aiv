package si.um.feri.aiv;

import jakarta.ejb.*;
import si.um.feri.aiv.ejb.Calculation;
import java.util.logging.Logger;

@Stateless
//@Stateful
public class CalcBean implements Calc {

	Logger log=Logger.getLogger(this.getClass().getName());

	private double history;
	
	private Calculation last;
	
	public double add(double a, double b) {
		log.info("Calc -> add");
		history=a+b;
		last=new Calculation(a + " + " + b,a+b);
		return a+b;
	}
	
	public double sub(double a, double b) {
		log.info("Calc -> sub");
		history=a-b;
		last=new Calculation(a + " - " + b,a-b);
		return a-b;
	}
	
	public double mul(double a, double b) {
		log.info("Calc -> mul");
		history=a*b;
		last=new Calculation(a + " * " + b,a*b);
		return a*b;
	}
	
	public double div(double a, double b) {
		log.info("Calc -> div");
		history=a/b;
		last=new Calculation(a + " / " + b,a/b);
		return a/b;
	}
	
	public double getHistory() {
		log.info("Calc -> getHistory");
		return history;
	}
	
	public Calculation getLastCalculation() {
		log.info("Calc -> getLastCalculation");
		return last;
	}
	
}
