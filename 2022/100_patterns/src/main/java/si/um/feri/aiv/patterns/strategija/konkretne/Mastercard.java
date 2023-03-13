package si.um.feri.aiv.patterns.strategija.konkretne;

import java.util.logging.Logger;
import si.um.feri.aiv.patterns.strategija.PlacilnoSredstvo;

public class Mastercard implements PlacilnoSredstvo {

	Logger log=Logger.getLogger(Mastercard.class.toString());
	
	@Override
	public String izvediPlacilo() {
		log.info("Plačujem z Masercardom");
		return "Plačujem z Masercardom";
	}

}
