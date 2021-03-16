package si.um.feri.aiv.patterns.observer.observers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Tehtnica implements Opazovalec {

	Logger log=LoggerFactory.getLogger(Tehtnica.class);
	
	public void akcija() {
		log.info("Upaš stopit gor?");
	}

}
