package si.um.feri.aiv.primer6;

import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface Ejb {

	OcenaKnjige najdi(int id);
	
	List<OcenaKnjige> vrniVse();
	
	List<OcenaKnjigeSKomentarjem> vrniVseSKomentarjem();
	
	OcenaKnjige shrani(OcenaKnjige o);
	
}
