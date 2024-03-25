package si.um.feri.aiv.patterns.adapter.adaptiranci;

import java.util.logging.Logger;

public class MailSender {

	Logger log=Logger.getLogger(MailSender.class.toString());

	public void posljiPosto(String kdo, String zadeva, String besedilo) {
		log.info("Pošiljam pošto: "+kdo+"; zadeva:"+zadeva+"; besedilo:"+besedilo);
	}
	
}
