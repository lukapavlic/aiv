package si.um.feri.cli.example1;

import si.um.feri.aiv.example1.*;
import si.um.feri.cli.MyInitialContextFactory;

public class EjbTest {

	public static void main(String[] args) throws Exception {
		Ejb ejb=(Ejb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/EjbBean!si.um.feri.aiv.example1.Ejb");
		ejb.action();
//
//		System.out.println(ejb.find("mojca@pokrajculja.si"));
//		System.out.println(ejb.find("peter@klepec.si"));

		Person o=new Person("Martin","Krpan","martin@krpan.si");
		System.out.println(ejb.save(o));

//		o.setIme("Martincek");
//		System.out.println(ejb.merge(o));
		
	}

}
