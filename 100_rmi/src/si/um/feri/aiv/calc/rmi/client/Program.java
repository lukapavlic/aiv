package si.um.feri.aiv.calc.rmi.client;

import java.rmi.Naming;
import si.um.feri.aiv.calc.rmi.server.Calc;

public class Program {

	public static void main(String[] args) throws Exception {
		
		Calc c=(Calc)Naming.lookup("//localhost/calc");
				//new Calculator();
		
		System.out.println(c.add(4, 5));
		
		System.out.println(c.getHistory());
		
		System.out.println(c.getLastCalculation());
		
		for (int i=0;i<5;i++) {
			System.out.println(c.add(c.getHistory(), 1));
		}
		
	}
	
}
