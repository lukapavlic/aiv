package si.um.feri;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.gen.Kalkulator;
import si.um.feri.gen.KalkulatorService;

public class KalkulatorTest {

	Logger log=LoggerFactory.getLogger(KalkulatorTest.class);
	
	@Test
	public void test() {
		Kalkulator kalk=new KalkulatorService().getKalkulatorPort();
		Assert.assertNotNull(kalk);
		
		int r=kalk.sestej(10,3);
		log.info(r+"");
		Assert.assertEquals(r, 13);

		r=kalk.odstej(10,3);
		log.info(r+"");
		Assert.assertEquals(r, 7);

		r=kalk.mnozi(10,3);
		log.info(r+"");
		Assert.assertEquals(r, 30);

		r=kalk.deli(10,3);
		log.info(r+"");
		Assert.assertEquals(r, 3);
		
		log.info(kalk.obdelaj(10,3).toString());
		
	}
	
}
