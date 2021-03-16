package si.um.feri.aiv;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("demors")
@RequestScoped
public class DemoRequestScopedBean implements Serializable {

	private static final long serialVersionUID = -7804846070746699266L;

	Logger log=LoggerFactory.getLogger(DemoRequestScopedBean.class);
	
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
