package si.um.feri.aiv.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import si.um.feri.aiv.dao.OsebaDao;
import si.um.feri.aiv.vao.Oseba;

/**
 * Pridobivanje vseh oseb iz podatkovne baze
 */
@ManagedBean(name="osebers")
@RequestScoped
public class DemoRequestScopedBean {

	Logger log=LoggerFactory.getLogger(DemoRequestScopedBean.class);
	
	List<Oseba> getVseOsebeRet=null;
	
	public List<Oseba> getVseOsebe(){
		log.info("JSF BEAN: getVseOsebe!");
		if (getVseOsebeRet==null) {
			try {
				getVseOsebeRet=OsebaDao.getInstance().vrniVse();		
			} catch (Exception e) {
				getVseOsebeRet=new ArrayList<>();
			}
		}
		return getVseOsebeRet;
	}
	
}
