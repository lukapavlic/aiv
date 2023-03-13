package si.um.feri.aiv.patterns.observer.observers;

import java.util.logging.Logger;
import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Tehtnica implements Opazovalec {

	Logger log=Logger.getLogger(Tehtnica.class.toString());
	
	public void akcija() {
		log.info("Upaš stopit gor?");
	}

}
