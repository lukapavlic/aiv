package si.um.feri.aiv.primer1;

import javax.naming.InitialContext;

public class EjbTest {

	public static void main(String[] args) throws Exception {
		
		Ejb ejb=InitialContext.doLookup("JpaDemo/EjbBean!si.um.feri.aiv.primer1.Ejb");
		
		ejb.akcija();
//		
//		System.out.println(ejb.najdi("mojca@pokrajculja.si"));
//		System.out.println(ejb.najdi("peter@klepec.si"));
//		
//		Oseba o=new Oseba("Martin","Krpan","martin@krpan.si");
//		System.out.println(ejb.shrani(o));
//		o.setIme("Martincek");
//		System.out.println(ejb.shraniMerge(o));
		
	}

}
