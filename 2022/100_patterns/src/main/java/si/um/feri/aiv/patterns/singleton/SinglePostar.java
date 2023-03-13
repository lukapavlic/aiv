package si.um.feri.aiv.patterns.singleton;

import java.util.logging.Logger;

/**
 * Edinec - implementacija s kreiranjem objekta neodvisno od uporabe
 * privaten konstruktor in pridobivanje objekta preko metode getInstance
 */
public class SinglePostar {
	
	Logger log=Logger.getLogger(SinglePostar.class.toString());

	private static SinglePostar instance=new SinglePostar();
	public static SinglePostar getInstance() {
		return instance;
	}
	
	private SinglePostar() {
		log.info("Rojstvo poštarja: "+this);
	}
	
	public void prinesiPosto() {
		log.info("Zdravo, sem "+this+" in sem ti prinesel pošto.");
	}
	
}
