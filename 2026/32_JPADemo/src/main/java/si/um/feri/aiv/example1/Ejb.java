package si.um.feri.aiv.example1;

import jakarta.ejb.Remote;

@Remote
public interface Ejb {

	Person find(String email);
	
	Person save(Person o);
	
	Person merge(Person o);
	
	void action();
	
}
