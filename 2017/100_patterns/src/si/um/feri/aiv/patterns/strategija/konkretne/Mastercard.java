package si.um.feri.aiv.patterns.strategija.konkretne;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.patterns.strategija.PlacilnoSredstvo;

public class Mastercard implements PlacilnoSredstvo {

	Logger log=LoggerFactory.getLogger(Mastercard.class);
	
	@Override
	public String izvediPlacilo() {
		log.info("Plaèujem z Masercardom");
		return "Plaèujem z Masercardom";
	}

}
