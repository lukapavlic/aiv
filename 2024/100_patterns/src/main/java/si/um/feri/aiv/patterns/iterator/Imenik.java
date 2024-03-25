package si.um.feri.aiv.patterns.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import si.um.feri.aiv.patterns.iterator.iteratorji.Iterator;
import si.um.feri.aiv.patterns.iterator.iteratorji.SmoZeNaKoncuKolekcijeException;

public class Imenik {

	Logger log=Logger.getLogger(Imenik.class.toString());
	
	private List<Oseba> list=new ArrayList<>();
	
	public void dodaj(Oseba o) {
		log.info("Dodajam "+o);
		list.add(o);
	}
	
	public Iterator<Oseba> vseOsebe() {
		Iterator<Oseba> ret=new Iterator<Oseba>() {
			
			private List<Oseba> c=new ArrayList<>(list);
			private int curr=0;
			
			@Override
			public boolean jeKonec() {
				if (curr<c.size()) {
					log.info("Nismo že na koncu.");
					return false;
				}
				log.info("Konec imenika.");
				return true;
			}
			@Override
			public Oseba naprej() throws SmoZeNaKoncuKolekcijeException {
				log.info("Naslednji, prosim.");
				if (jeKonec()) throw new SmoZeNaKoncuKolekcijeException();
				return c.get(curr++);
			}
		};
		return ret;
	}
	
}
