package si.um.feri.aiv.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import si.um.feri.aiv.ejb.Osebe;
import si.um.feri.aiv.vao.Oseba;

@Named("demors")
@RequestScoped
public class DemoRequestScopedBean implements Serializable {

	private static final long serialVersionUID = 9048166857069095002L;

	Logger log=Logger.getLogger(DemoRequestScopedBean.class.toString());
	
	@EJB
	private Osebe ejb;
	
	List<Oseba> getVseOsebeRet=null;
	
	public List<Oseba> getVseOsebe(){
		log.info("JSF BEAN: getVseOsebe");
		
		if (getVseOsebeRet==null) {
			try {
				getVseOsebeRet=ejb.vrniVse();
			} catch (Exception e) {
				getVseOsebeRet=new ArrayList<>();
			}
		}
		
		return getVseOsebeRet;
	}
	
}
