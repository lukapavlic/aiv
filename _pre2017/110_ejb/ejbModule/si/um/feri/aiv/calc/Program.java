package si.um.feri.aiv.calc;

import javax.naming.InitialContext;

public class Program {

	public static void main(String[] args) throws Exception {
		
		Calculator c=(Calculator)new InitialContext().lookup("110_ejb/CalculatorBean!si.um.feri.aiv.calc.Calculator");
				//new CalculatorBean();
		System.out.println(c.add(4, 5));
		
	}
	
}
