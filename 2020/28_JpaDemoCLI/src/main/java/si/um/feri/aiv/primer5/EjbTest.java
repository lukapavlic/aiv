package si.um.feri.aiv.primer5;

import javax.naming.InitialContext;

public class EjbTest {

	public static void main(String[] args) throws Exception {

		Ejb ejb=InitialContext.doLookup("JpaDemo/ejbPet!si.um.feri.aiv.primer5.Ejb");
		
		Oseba o=new Oseba("Martin","Krpan","martin@krpan.si");
		o.dodajKontakt(new Kontakt("telefon","051 051 051"));
		o.dodajKontakt(new Kontakt("email","email"));
		o=ejb.shrani(o);
		
		System.out.println(o);
		for (Kontakt k :o.getKontakti()) {
			System.out.println(k);
			System.out.println(k.getOseba());
			System.out.println(ejb.najdiKontakt(k.getId()).getOseba());
		}
		
		Oseba o2=ejb.najdi(o.getId());
		System.out.println(o2);
		for (Kontakt k :o2.getKontakti()) {
			System.out.println(k);
			System.out.println(k.getOseba());
			System.out.println(ejb.najdiKontakt(k.getId()).getOseba());
		}
		
	}

}
