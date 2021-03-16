package si.um.feri.aiv.fitnes.jsf;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import si.um.feri.aiv.fitnes.ejb.TreningiBean;
import si.um.feri.aiv.fitnes.vao.Trening;

@Named("urejanjetreninga")
@SessionScoped
public class UrejanjeJSFBean implements Serializable {

	private static final long serialVersionUID = -8641006452122414426L;

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

	public void preklici() {
		izbranTrening=new Trening();
	}
			
	public void shrani(long id) {
		if (id>0) {
			Trening t=ejb.najdi(id);
			t.setNaziv(izbranTrening.getNaziv());
			t.setStranka(izbranTrening.getStranka());
			t.setTrener(izbranTrening.getTrener());
			t.setUstvarjen(izbranTrening.getUstvarjen());
			t.setDniVCiklu(izbranTrening.getDniVCiklu());
			ejb.merge(t);
		} else {
			ejb.shrani(izbranTrening);
		}
		izbranTrening=new Trening();
	}
	
}
