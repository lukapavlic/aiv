package si.um.feri.aiv.patterns.strategija;

public class SpletnaTrgovina {

	PlacilnoSredstvo ps;
	
	public SpletnaTrgovina(PlacilnoSredstvo privzetoPlacilnoSredstvo) {
		ps=privzetoPlacilnoSredstvo;
	}
	
	private void izberiPlacilnoSredstvo() {
		//if-then-else ...
		//ps=new Mastercard();
		//ps=new Visa();
		//ps=new PayPal();
	}
	
	public String placajNakup() {
		izberiPlacilnoSredstvo();
		return ps.izvediPlacilo();
	}
	
}
