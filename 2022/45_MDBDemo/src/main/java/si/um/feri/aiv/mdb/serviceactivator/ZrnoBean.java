package si.um.feri.aiv.mdb.serviceactivator;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
@Local(Zrno.class)
public class ZrnoBean implements Zrno {

	Logger log=Logger.getLogger(ZrnoBean.class.toString());
	
	@Override
	public void metoda() {
		log.info("ZrnoBean.metoda()");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("ZrnoBean.metoda() - koncano");
	}
	
}
