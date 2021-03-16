package si.um.feri.aiv.soapclient;

import si.um.feri.aiv.soapclient.gen.Oseba;
import si.um.feri.aiv.soapclient.gen.OsebeSoap;
import si.um.feri.aiv.soapclient.gen.OsebeSoapService;

public class OsebeSoapClient {

	public static void main(String[] args) {
		
		OsebeSoap os=new OsebeSoapService().getOsebeSoapPort();
		
//		Oseba o=new Oseba();
//		o.setIme("Rdeca");
//		o.setPriimek("Kapica");
//		os.dodajOsebo(o);
		
		for (Oseba oo : os.vrniVseOsebe()) {
			System.out.println(oo.getPriimek() + " "+oo.getIme());
		}
	

			
	}
	
}
