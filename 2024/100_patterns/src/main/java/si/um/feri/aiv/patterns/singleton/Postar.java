package si.um.feri.aiv.patterns.singleton;

import java.util.logging.Logger;

public class Postar {
	
	Logger log=Logger.getLogger(Postar.class.toString());

	public Postar() {
		log.info("Rojstvo poštarja: "+this);
	}
	
	public void prinesiPosto() {
		log.info("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
