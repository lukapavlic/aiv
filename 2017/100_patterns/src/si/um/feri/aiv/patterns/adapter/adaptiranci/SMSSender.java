package si.um.feri.aiv.patterns.adapter.adaptiranci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SMSSender {

	Logger log=LoggerFactory.getLogger(SMSSender.class);

	public void posljiSMS(String stevilka, String besedilo) {
		log.info("Pošiljam SMS: "+stevilka+"; besedilo:"+besedilo);
	}
	
}
