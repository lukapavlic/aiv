package si.um.feri.aiv.patterns.iterator;

import org.junit.Test;
import si.um.feri.aiv.patterns.iterator.iteratorji.Iterator;
import java.util.logging.Logger;

public class ImenikTest {
	
	Logger log=Logger.getLogger(ImenikTest.class.toString());

	@Test
	public void iteratorTest() {
		Imenik i=new Imenik();
		i.dodaj(new Oseba("Peter", "Klepec",""));
		i.dodaj(new Oseba("Martin", "Krpan",""));
		i.dodaj(new Oseba("Rdeča", "Kapica",""));
		
		Iterator<Oseba> iterator=i.vseOsebe();
		while (!iterator.jeKonec()) {
			try {
				System.out.println(iterator.naprej());
			} catch (Exception e) {
				log.info(e.toString());
			}
		}
		
	}
	
}
