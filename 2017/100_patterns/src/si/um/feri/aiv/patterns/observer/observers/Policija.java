package si.um.feri.aiv.patterns.observer.observers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Policija implements Opazovalec {

	Logger log=LoggerFactory.getLogger(Policija.class);
	
	public void akcija() {
		log.info("Je bilo kaj pijaèe?");
	}

}
