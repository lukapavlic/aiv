package si.um.feri.aiv.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	//	WF says:
	//	
	//	java:global/020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorLocal
	//	java:app/020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorLocal
	//	java:module/CalculatorBean!si.um.feri.aiv.ejb.CalculatorLocal
	//	java:jboss/exported/020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorLocal
	//	java:global/020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorRemote
	//	java:app/020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorRemote
	//	java:module/CalculatorBean!si.um.feri.aiv.ejb.CalculatorRemote
	//	java:jboss/exported/020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorRemote

	CalculatorRemote calc;
	
	@Before
	public void before() {
		try {
			calc=(CalculatorRemote)new InitialContext().lookup("020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorRemote");
			System.out.println(calc);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPovezovanja() {
		Assert.assertTrue(calc instanceof CalculatorRemote);
		Assert.assertFalse(calc instanceof CalculatorBean);
	}
	
	@Test(expected=NamingException.class)
	public void testPovezovanjaNaLokalniVmesnik() throws NamingException {
		new InitialContext().lookup("020_ejbRemote/CalculatorBean!si.um.feri.aiv.ejb.CalculatorLocal");
	}
	
}
