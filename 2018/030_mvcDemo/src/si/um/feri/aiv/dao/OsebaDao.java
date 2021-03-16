package si.um.feri.aiv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import si.um.feri.aiv.Oseba;

/**
 * Dummy DB
 */
public class OsebaDao {
	
	private static List<Oseba> osebe=Collections.synchronizedList(new ArrayList<Oseba>());
	
	public void shrani(Oseba o) throws Exception {
		osebe.add(o);
	}
	
	public Oseba najdiOsebo(int id) throws Exception {
		for (Oseba o:osebe) 
			if (o.getId()==id) 
				return o;
		return null;
	}
	
	public List<Oseba> vrniVse() throws Exception {
		return osebe;
	}

}
