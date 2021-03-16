package si.um.feri.aiv.patterns.strategija.konkretne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.strategija.PlacilnoSredstvo;

public class Visa implements PlacilnoSredstvo {

	Logger log=LoggerFactory.getLogger(Visa.class);
	
	@Override
	public String izvediPlacilo() {
		log.info("Plaèujem z Viso");
		return "Plaèujem z Viso";
	}

}
