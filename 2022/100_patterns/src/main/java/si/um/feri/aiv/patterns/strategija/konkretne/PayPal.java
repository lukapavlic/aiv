package si.um.feri.aiv.patterns.strategija.konkretne;

import java.util.logging.Logger;
import si.um.feri.aiv.patterns.strategija.PlacilnoSredstvo;

public class PayPal implements PlacilnoSredstvo {

	Logger log=Logger.getLogger(PayPal.class.toString());
	
	@Override
	public String izvediPlacilo() {
		log.info("Plačujem s PayPal-om");
		return "Plačujem s PayPal-om";
	}
	
}
