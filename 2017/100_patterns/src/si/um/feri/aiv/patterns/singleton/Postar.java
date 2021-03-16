package si.um.feri.aiv.patterns.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Postar {
	
	Logger log=LoggerFactory.getLogger(Postar.class);

	public Postar() {
		log.info("Rojstvo poštarja: "+this);
	}
	
	public void prinesiPosto() {
		log.info("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
