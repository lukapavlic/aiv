package si.um.feri.aiv;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean(name="demors")
@RequestScoped
public class DemoRequestScopedBean {

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
