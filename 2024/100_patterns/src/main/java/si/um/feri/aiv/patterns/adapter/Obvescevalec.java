package si.um.feri.aiv.patterns.adapter;

import java.util.logging.Logger;

import si.um.feri.aiv.patterns.adapter.adaptiranci.MailSender;

public class Obvescevalec {
	
	Logger log=Logger.getLogger(MailSender.class.toString());

	public String obvestilo(String text) {
		String ret="Obveščam: "+text;
		log.info(ret);
		return ret;
	}
}
