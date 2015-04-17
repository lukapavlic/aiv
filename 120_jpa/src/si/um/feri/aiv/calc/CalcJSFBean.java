package si.um.feri.aiv.calc;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="calc")
@SessionScoped
public class CalcJSFBean {

	@EJB
	private Calculator c;
	
	public void gumbek() {
		c.add(2, 3);
		c.demo();
	}
	
}
