package si.um.feri.aiv.DSDemo;

import java.util.List;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

@ManagedBean(name="demo")
@SessionScoped
public class Demo {
	
	private Oseba oseba=new Oseba();

	@Resource(lookup="java:jboss/datasource/PetekBaza")
//	@Resource(lookup="java:jboss/datasources/ExampleDS")
	DataSource baza;
	
	public List<Oseba> getOsebe() throws Exception {
		return new OsebaDao(baza).vrniVse();
	}

	public void test() throws Exception {
		OsebaDao od=new OsebaDao(baza);
		Oseba o=new Oseba("Božièek", "Prišel",-1);
		System.out.println(o);
		od.shrani(o);
		System.out.println(o);
		System.out.println(od.najdi(o.getId()));
	}
	
	public void shrani() throws Exception {
		OsebaDao od=new OsebaDao(baza);
		od.shrani(oseba);
		oseba=new Oseba();
	}
	
	public void spremeni(Oseba o) {
		oseba=o;
	}

	public Oseba getOseba() {
		return oseba;
	}

	public void setOseba(Oseba oseba) {
		this.oseba = oseba;
	}
	
}
