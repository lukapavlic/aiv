package si.um.feri.aiv.o2mbothsides;

public interface Ejb1M {

	Person1M find(int id);
	
	Person1M save(Person1M o);
	
	void doIt();
	
}
