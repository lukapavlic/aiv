package si.um.feri.cli.primer4;

import si.um.feri.cli.MyInitialContextFactory;
import si.um.feri.aiv.primer4.*;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=(Ejb)MyInitialContextFactory.getInitialContext().lookup("JPADemo/ejbStiri!si.um.feri.aiv.primer4.Ejb");
		
		Oseba o=new Oseba("Martin","Krpan","martin@krpan.si");
		o.getKontakti().add(new Kontakt("telefon","051 051 051"));
		o.getKontakti().add(new Kontakt("email","email"));
		o=ejb.shrani(o);
		
		System.out.println(o.getId());
		
		Oseba o2=ejb.najdi(o.getId());
		System.out.println(o2);
		for (Kontakt k :o2.getKontakti())
			System.out.println(k);
		
	}

}
