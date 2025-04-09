package si.um.feri.aiv.one2many;

public interface Ejb {

	Person find(int id);
	
	Person save(Person o);
	
	void doIt(int id);
	
}
