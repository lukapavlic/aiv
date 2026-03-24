package si.um.feri.aiv.example1;

public interface Ejb {

	Person find(String email);
	
	Person save(Person o);
	
	Person merge(Person o);
	
	void action();
	
}
