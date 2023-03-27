package si.um.feri.aiv.primer2;

import jakarta.ejb.Remote;

@Remote
public interface CmtEjb {

	Oseba novaOseba();
	
	void dveNoviOsebi();
	
	void smoSeSamoHecali();
	
}
