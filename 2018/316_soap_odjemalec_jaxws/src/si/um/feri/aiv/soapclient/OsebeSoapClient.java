package si.um.feri.aiv.soapclient;

import si.um.feri.aiv.soapclient.gen.Oseba;
import si.um.feri.aiv.soapclient.gen.OsebeSoap;
import si.um.feri.aiv.soapclient.gen.OsebeSoapService;

public class OsebeSoapClient {

	public static void main(String[] args) {
		
		OsebeSoap os=new OsebeSoapService().getOsebeSoapPort();
		
		for (Oseba o : os.vrniVseOsebe()) {
			System.out.println(o.getPriimek() + " "+o.getIme());
		}
			
	}
	
}
