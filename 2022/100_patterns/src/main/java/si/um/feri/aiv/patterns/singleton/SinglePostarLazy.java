package si.um.feri.aiv.patterns.singleton;

import java.util.logging.Logger;

/**
 * Edinec - implementacija s kreiranjem objekta ob prvi uporabi
 * privaten konstruktor in pridobivanje objekta preko metode getInstance
 */
public class SinglePostarLazy {
	
	Logger log=Logger.getLogger(SinglePostarLazy.class.toString());

	private static SinglePostarLazy instance=null;
	public static synchronized SinglePostarLazy getInstance() {
		if (instance==null) instance=new SinglePostarLazy();
		return instance;
	}
	
	private SinglePostarLazy() {
		log.info("Rojstvo poštarja: "+this);
	}
	
	public void prinesiPosto() {
		log.info("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
