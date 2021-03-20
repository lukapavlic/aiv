package si.um.feri.aiv.primer3;

import javax.naming.InitialContext;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=InitialContext.doLookup("JpaDemo/ejbTri!si.um.feri.aiv.primer3.Ejb");
		
		Oseba o=new Oseba("Martin","Krpan","martin@krpan.si");
		o.getKontakti().add(new Kontakt("telefon","051 051 051"));
		o.getKontakti().add(new Kontakt("email","email"));
		o=ejb.shrani(o);
		
		System.out.println(o.getId());
		
//		Oseba o2=ejb.najdi(o.getId());
//		System.out.println(o2);
//		for (Kontakt k :o2.getKontakti())
//			System.out.println(k);
		
//		ejb.akcija(o.getId());

	}

}
