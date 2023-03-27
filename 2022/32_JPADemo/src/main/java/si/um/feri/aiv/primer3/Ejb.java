package si.um.feri.aiv.primer3;

import jakarta.ejb.Remote;

@Remote
public interface Ejb {

	Oseba najdi(int id);
	
	Oseba shrani(Oseba o);
	
	void akcija(int id);
	
}
