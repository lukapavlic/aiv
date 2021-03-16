package si.um.feri.aiv.patterns.adapter.adaptiranci;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MailSender {

	Logger log=LoggerFactory.getLogger(MailSender.class);

	public void posljiPosto(String kdo, String zadeva, String besedilo) {
		log.info("Pošiljam pošto: "+kdo+"; zadeva:"+zadeva+"; besedilo:"+besedilo);
	}
	
}
