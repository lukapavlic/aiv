package si.um.feri.aiv.mdb.serviceactivator;

import javax.ejb.Local;
import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@Local(Zrno.class)
public class ZrnoBean implements Zrno {

	Logger log=LoggerFactory.getLogger(ZrnoBean.class);
	
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
