package si.um.feri.aiv.example2;

import jakarta.ejb.Remote;

@Remote
public interface CmtEjb {

	Person newPerson();
	
	void twoNewPeople();
	
	void justKiddin();
	
}
