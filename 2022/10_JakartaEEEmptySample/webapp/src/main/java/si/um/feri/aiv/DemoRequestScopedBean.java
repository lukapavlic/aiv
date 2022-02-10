package si.um.feri.aiv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("demors")
@RequestScoped
public class DemoRequestScopedBean implements Serializable {

	private static final long serialVersionUID = -7804846070746699266L;

	Logger log=Logger.getLogger(DemoRequestScopedBean.class.toString());
	
	private OsebaDao dao=new OsebaDao();
	
	List<Oseba> getVseOsebeRet=null;
	
	public List<Oseba> getVseOsebe(){
		log.info("JSF BEAN: getVseOsebe");
		
		if (getVseOsebeRet==null) {
			try {
				getVseOsebeRet=dao.vrniVse();
			} catch (Exception e) {
				getVseOsebeRet=new ArrayList<>();
			}
		}
		
		return getVseOsebeRet;
	}
	
}
