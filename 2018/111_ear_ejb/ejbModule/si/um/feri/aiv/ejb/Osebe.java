package si.um.feri.aiv.ejb;

import java.util.List;

//tip vmesnika je naveden pri EJB razredu
public interface Osebe {

	List<String> vrniVsaImena();
	
	void dodajIme(String ime);
	
}
