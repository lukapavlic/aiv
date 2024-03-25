package si.um.feri.aiv.patterns.adapter.adaptiranci;

import java.util.logging.Logger;

public class SMSSender {

	Logger log=Logger.getLogger(SMSSender.class.toString());

	public void posljiSMS(String stevilka, String besedilo) {
		log.info("Pošiljam SMS: "+stevilka+"; besedilo:"+besedilo);
	}
	
}
