package si.um.feri.aiv.patterns.strategija.konkretne;

import java.util.logging.Logger;
import si.um.feri.aiv.patterns.strategija.PlacilnoSredstvo;

public class Visa implements PlacilnoSredstvo {

	Logger log=Logger.getLogger(Visa.class.toString());
	
	@Override
	public String izvediPlacilo() {
		log.info("Plačujem z Viso");
		return "Plačujem z Viso";
	}

}
