package si.um.feri.aiv.primer6;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Ejb {

	OcenaKnjige najdi(int id);
	
	List<OcenaKnjige> vrniVse();
	
	List<OcenaKnjigeSKomentarjem> vrniVseSKomentarjem();
	
	OcenaKnjige shrani(OcenaKnjige o);
	
}
