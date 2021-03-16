package si.um.feri.aiv.fitnes.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import si.um.feri.aiv.fitnes.ejb.DemoBean;
import si.um.feri.aiv.fitnes.vao.Trening;

@Named("demo")
@RequestScoped
public class DemoJSFBean implements Serializable {

	private static final long serialVersionUID = -5268886260842400092L;
	
	@EJB
	DemoBean ejb;

	public void demo1() {
		ejb.demo1();
	}
	
	public void demo2() {
		ejb.demo2();
	}

	public void demo3() {
		Trening t=ejb.demo3();
		t.setStranka("Palèek Smuk");
		ejb.demo4(t);
	}
	
}
