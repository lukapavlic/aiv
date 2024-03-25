package si.um.feri.aiv.patterns.adapter;

import org.junit.Assert;
import org.junit.Test;
import si.um.feri.aiv.patterns.adapter.adaptiranci.MailSenderAdapter;

public class PostarTest {

	@Test
	public void testPrivzetoObvescanje() {
		Postar mirko=new Postar();
		String msg=mirko.prinesiPosto();
		Assert.assertTrue(msg.contains("Obveščam"));
	}
	
	@Test
	public void testSMSObvescanje() {
		Postar mirko=new Postar("sms");
		String msg=mirko.prinesiPosto();
		Assert.assertTrue(msg.contains("sms"));
	}
	
	@Test
	public void testMailObvescanje() {
		Postar mirko=new Postar(MailSenderAdapter.class);
		String msg=mirko.prinesiPosto();
		Assert.assertTrue(msg.contains("jaz@podjetje.si"));
	}
	
}
