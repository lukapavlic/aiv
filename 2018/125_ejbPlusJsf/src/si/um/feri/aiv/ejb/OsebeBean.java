package si.um.feri.aiv.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateful
@Remote(Osebe.class)
public class OsebeBean implements Osebe {

	Logger log=LoggerFactory.getLogger(OsebeBean.class);
	
	private List<String> imena=new ArrayList<>();
	
	@Override
	public void dodajIme(String ime) {
		log.info("Dodajam ime.");
		imena.add(ime);
	}
	
	@Override
	public List<String> vrniVsaImena() {
		log.info("Vraèam vsa imena.");
		return imena;
	}
}
