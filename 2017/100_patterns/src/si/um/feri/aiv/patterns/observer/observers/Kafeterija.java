package si.um.feri.aiv.patterns.observer.observers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.patterns.observer.Opazovalec;

public class Kafeterija implements Opazovalec {

	Logger log=LoggerFactory.getLogger(Kafeterija.class);
	
	public void akcija() {
		log.info("Še kakšno kavico?");
	}
	
}
