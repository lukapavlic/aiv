package si.um.feri.aiv.patterns.observer.observers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Lekarna implements Opazovalec {

	Logger log=LoggerFactory.getLogger(Lekarna.class);
	
	public void akcija() {
		log.info("Bi en Rupurut? Lekadol?");
	}
	
}
