package si.um.feri.aiv.primer2;

import javax.naming.InitialContext;

public class CmtEjbTest {

	public static void main(String[] args) throws Exception {
		
		CmtEjb ejb=InitialContext.doLookup("JpaDemo/CmtEjbBean!si.um.feri.aiv.primer2.CmtEjb");
		
		ejb.novaOseba();
		
		//ejb.dveNoviOsebi();
		
		//ejb.smoSeSamoHecali();
		
	}

}
