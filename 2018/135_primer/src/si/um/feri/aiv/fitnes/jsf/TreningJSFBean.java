package si.um.feri.aiv.fitnes.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import si.um.feri.aiv.fitnes.ejb.TreningiBean;
import si.um.feri.aiv.fitnes.vao.Trening;

@Named("pregledtreninga")
@RequestScoped
public class TreningJSFBean implements Serializable {

	private static final long serialVersionUID = 997614964798652139L;

	@EJB
	TreningiBean ejb;
	
	private Trening izbranTrening=new Trening();
	
	private String izbranTreningId;
	
	public Trening getIzbranTrening() {
		return izbranTrening;
	}

	public void setIzbranTrening(Trening izbranTrening) {
		this.izbranTrening = izbranTrening;
	}

	public String getIzbranTreningId() {
		return izbranTreningId;
	}

	public void setIzbranTreningId(String izbranTreningId) {
		this.izbranTreningId = izbranTreningId;
		izbranTrening=ejb.najdi(Long.parseLong(izbranTreningId));
	}
	
}
