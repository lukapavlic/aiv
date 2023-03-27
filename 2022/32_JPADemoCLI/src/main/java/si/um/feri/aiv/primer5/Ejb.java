package si.um.feri.aiv.primer5;


public interface Ejb {

	Oseba najdi(int id);
	
	Kontakt najdiKontakt(int id);
	
	Oseba shrani(Oseba o);
	
}
