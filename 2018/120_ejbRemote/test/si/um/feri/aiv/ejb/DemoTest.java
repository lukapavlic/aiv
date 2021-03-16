package si.um.feri.aiv.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DemoTest {
	
	//	WF says:
	//		
	//	java:global/120_ejbRemote/DemoBean!si.um.feri.aiv.ejb.Demo
	//	java:app/120_ejbRemote/DemoBean!si.um.feri.aiv.ejb.Demo
	//	java:module/DemoBean!si.um.feri.aiv.ejb.Demo
	//	java:jboss/exported/120_ejbRemote/DemoBean!si.um.feri.aiv.ejb.Demo
	//	java:global/120_ejbRemote/DemoBean
	//	java:app/120_ejbRemote/DemoBean
	//	java:module/DemoBean
	
	Demo demo;
	
	@Before
	public void before() {
		try {
			demo=(Demo)new InitialContext().lookup("120_ejbRemote/DemoBean!si.um.feri.aiv.ejb.Demo");
			System.out.println(demo);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testPovezovanja() {
		Assert.assertTrue(demo instanceof Demo);
		Assert.assertFalse(demo instanceof DemoBean);
	}
	
	@Test
	public void testPozdrav() {
		Assert.assertEquals(demo.pozdraviMe("Zvonko"),"Zdravo, Zvonko");
	}
	
	@Test
	public void testRacunaj() {
		Assert.assertEquals(demo.racunaj(2,3,4),20.0,0.0);
	}
	
}
