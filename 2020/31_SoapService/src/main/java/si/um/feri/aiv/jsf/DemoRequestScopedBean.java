package si.um.feri.aiv.jsf;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import si.um.feri.aiv.ejb.OsebeBean;
import si.um.feri.aiv.vao.Oseba;

@Named("demors")
@RequestScoped
public class DemoRequestScopedBean {

	Logger log=LoggerFactory.getLogger(DemoRequestScopedBean.class);
	
	@EJB
	private OsebeBean ejb;
	
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
