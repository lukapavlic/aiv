package si.um.feri.aiv.mdb.serviceactivator;

import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import java.util.logging.Logger;

@Stateless
@Local(LazyOne.class)
public class LazyOneBean implements LazyOne {

	Logger log=Logger.getLogger(LazyOneBean.class.toString());
	
	@Override
	public void slowMethod() {
		log.info("LazyOneBean.slowMethod()");
		try {
			Thread.sleep(10_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("LazyOneBean.slowMethod() - finished");
	}
	
}
