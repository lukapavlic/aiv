package si.um.feri.aiv.ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.vao.Oseba;

@Stateless
public class OsebeDaoBean implements OsebeDao {

	Logger log=LoggerFactory.getLogger(OsebeDaoBean.class);
	
	private static List<Oseba> osebe=Collections.synchronizedList(new ArrayList<Oseba>());
	
	@Override
	public Oseba najdi(String email)  {
		for (Oseba o : osebe)
			if (o.getEmail().equals(email))
				return o;
		return new Oseba();
	}

	@Override
	public void shrani(Oseba o)  {
		log.info("DAO: shranjujem "+o);
		osebe.add(o);
	}

	@Override
	public List<Oseba> vrniVse() {
		log.info("DAO: vracam vse");
		return osebe;
	}

}