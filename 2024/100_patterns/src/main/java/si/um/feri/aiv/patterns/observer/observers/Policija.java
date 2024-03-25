package si.um.feri.aiv.patterns.observer.observers;

import java.util.logging.Logger;
import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Policija implements Opazovalec {

	Logger log=Logger.getLogger(Policija.class.toString());
	
	public void akcija() {
		log.info("Je bilo kaj pijače?");
	}

}
