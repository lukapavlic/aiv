package si.um.feri.aiv.fitnes.jsf;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import si.um.feri.aiv.fitnes.ejb.TreningiBean;
import si.um.feri.aiv.fitnes.vao.Trening;

@Named("vsitreningi")
@RequestScoped
public class VsiTreningiJSFBean implements Serializable {

	private static final long serialVersionUID = -85487489836556422L;

	@EJB
	TreningiBean ejb;

	private List<Trening> cache;
	
	public List<Trening> getVsiTreningi() {
		if (cache==null) cache=ejb.vsiTreningi();
		return cache;
	}
	
}
