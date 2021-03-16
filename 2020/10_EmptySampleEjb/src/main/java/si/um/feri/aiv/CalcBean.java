package si.um.feri.aiv;

import javax.ejb.Stateless;

import si.um.feri.aiv.ejb.Calculation;

@Stateless
public class CalcBean implements Calc {

	private double history;
	
	private Calculation last;
	
	public double add(double a, double b) {
		System.out.println("Calc -> add");
		history=a+b;
		last=new Calculation(a + " + " + b,a+b);
		return a+b;
	}
	
	public double sub(double a, double b) {
		System.out.println("Calc -> sub");
		history=a-b;
		last=new Calculation(a + " - " + b,a-b);
		return a-b;
	}
	
	public double mul(double a, double b) {
		System.out.println("Calc -> mul");
		history=a*b;
		last=new Calculation(a + " * " + b,a*b);
		return a*b;
	}
	
	public double div(double a, double b) {
		System.out.println("Calc -> div");
		history=a/b;
		last=new Calculation(a + " / " + b,a/b);
		return a/b;
	}
	
	public double getHistory() {
		System.out.println("Calc -> getHistory");
		return history;
	}
	
	public Calculation getLastCalculation() {
		System.out.println("Calc -> getLastCalculation");
		return last;
	}
	
}
