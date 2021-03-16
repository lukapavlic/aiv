package si.um.feri.aiv.mdb.serviceactivator;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(Zrno.class)
public class ZrnoBean implements Zrno {

	@Override
	public void metoda() {
		System.out.println("ZrnoBean.metoda()");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ZrnoBean.metoda() - konèano");
	}
	
}
