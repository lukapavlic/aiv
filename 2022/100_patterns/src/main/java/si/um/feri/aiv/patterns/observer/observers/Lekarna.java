package si.um.feri.aiv.patterns.observer.observers;

import java.util.logging.Logger;

import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Lekarna implements Opazovalec {

	Logger log=Logger.getLogger(Lekarna.class.toString());
	
	public void akcija() {
		log.info("Bi en Rupurut? Lekadol?");
	}
	
}
