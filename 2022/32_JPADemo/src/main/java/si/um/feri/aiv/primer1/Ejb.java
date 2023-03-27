package si.um.feri.aiv.primer1;

import jakarta.ejb.Remote;

@Remote
public interface Ejb {

	Oseba najdi(String email);
	
	Oseba shrani(Oseba o);
	
	Oseba shraniMerge(Oseba o);
	
	void akcija();
	
}
