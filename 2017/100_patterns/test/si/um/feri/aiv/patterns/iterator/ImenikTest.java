package si.um.feri.aiv.patterns.iterator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.iterator.iteratorji.Iterator;

public class ImenikTest {
	
	Logger log=LoggerFactory.getLogger(ImenikTest.class);

	@Test
	public void iteratorTest() {
		Imenik i=new Imenik();
		i.dodaj(new Oseba("Peter", "Klepec",""));
		i.dodaj(new Oseba("Martin", "Krpan",""));
		i.dodaj(new Oseba("Rdeèa", "Kapica",""));
		
		Iterator<Oseba> iterator=i.vseOsebe();
		while (!iterator.jeKonec()) {
			try {
				System.out.println(iterator.naprej());
			} catch (Exception e) {
				log.error(e.toString());
			}
		}
		
	}
	
}
