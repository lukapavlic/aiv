package si.um.feri.aiv.ejb;

import javax.naming.InitialContext;
import si.um.feri.aiv.Calc;

public class CalcTest {

	// WF says:
	//
	// java:global/EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// java:app/EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// java:module/CalcBean!si.um.feri.aiv.Calc
	// java:jboss/exported/EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// ejb:EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc
	// java:global/EmptySampleEjb/CalcBean
	// java:app/EmptySampleEjb/CalcBean
	// java:module/CalcBean
	
	public static void main(String[] args) throws Exception {

		InitialContext ctx=new InitialContext();
		
		Calc c = (Calc) ctx.lookup("EmptySampleEjb/CalcBean!si.um.feri.aiv.Calc");

		System.out.println(c.add(4, 5));

		System.out.println(c.getHistory());

		System.out.println(c.getLastCalculation());

		for (int i = 0; i < 5; i++) {
			System.out.println(c.add(c.getHistory(), 1));
		}
		
		System.out.println("------------------------------");
		
		Demo demo=(Demo) ctx.lookup("EmptySampleEjb/DemoBean!si.um.feri.aiv.ejb.Demo");
		System.out.println(demo.racunaj(1, 2, 3));
		
	}

}
