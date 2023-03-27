package si.um.feri.aiv.primer1;

public interface Ejb {

	Oseba najdi(String email);
	
	Oseba shrani(Oseba o);
	
	Oseba shraniMerge(Oseba o);
	
	void akcija();
	
}
