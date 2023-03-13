package si.um.feri.aiv.patterns.strategija;

import org.junit.Assert;
import org.junit.Test;

import si.um.feri.aiv.patterns.strategija.konkretne.Mastercard;
import si.um.feri.aiv.patterns.strategija.konkretne.PayPal;
import si.um.feri.aiv.patterns.strategija.konkretne.Visa;

public class SpletnaTrgovinaTest {

	@Test
	public void testVisa() {
		SpletnaTrgovina st=new SpletnaTrgovina(new Visa());
		Assert.assertEquals(st.placajNakup(), "Plačujem z Viso");
	}
	
	@Test
	public void testPaypal() {
		SpletnaTrgovina st=new SpletnaTrgovina(new PayPal());
		Assert.assertEquals(st.placajNakup(), "Plačujem s PayPal-om");
	}
	
	@Test
	public void testMastercard() {
		SpletnaTrgovina st=new SpletnaTrgovina(new Mastercard());
		Assert.assertEquals(st.placajNakup(), "Plačujem z Masercardom");
	}
	
}
