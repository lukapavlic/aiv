package si.um.feri.cli.primer3;

import si.um.feri.cli.MyInitialContextFactory;
import si.um.feri.aiv.primer3.*;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=(Ejb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/ejbTri!si.um.feri.aiv.primer3.Ejb");
		
		Oseba o=new Oseba("Martin","Krpan","martin@krpan.si");
		o.getKontakti().add(new Kontakt("telefon","051 051 051"));
		o.getKontakti().add(new Kontakt("email","email"));
		o=ejb.shrani(o);
		
//		System.out.println(o.getId());
//
//		Oseba o2=ejb.najdi(o.getId());
//		System.out.println(o2);
//		for (Kontakt k :o2.getKontakti())
//			System.out.println(k);
//
//		ejb.akcija(o.getId());

	}

}
