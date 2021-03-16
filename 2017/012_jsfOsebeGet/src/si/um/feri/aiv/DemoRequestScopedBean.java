package si.um.feri.aiv;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="demors")
@RequestScoped
public class DemoRequestScopedBean {

	private OsebaDao dao=new OsebaDao();
	
	List<Oseba> getVseOsebeRet=null;
	
	public List<Oseba> getVseOsebe(){
		System.out.println("JSF BEAN: getVseOsebe");
		
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
