package si.um.feri.aiv.patterns.observer.observers;

import java.util.logging.Logger;

import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Kafeterija implements Opazovalec {

	Logger log=Logger.getLogger(Kafeterija.class.toString());
	
	public void akcija() {
		log.info("Še kakšno kavico?");
	}
	
}
